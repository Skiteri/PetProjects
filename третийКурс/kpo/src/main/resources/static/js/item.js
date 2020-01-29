function getIndex(list, id) {
    for (var i = 0; i < list.length; i++ ) {
        if (list[i].id === id) {
            return i;
        }
    }
    return -1;
}


const itemApi = Vue.resource('/item{/id}');
const userApi = Vue.resource('/user{/id}');
const orderApi = Vue.resource('/order{/id}');


Vue.component('message-form', {
    props: ['messages', 'messageAttr'],
    data: function() {
        return {
            description: '',
            price: '',
            id: ''
        }
    },
    watch: {
        messageAttr: function(newVal, oldVal) {
            this.description = newVal.description;
            this.price = newVal.price;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
            '<input type="text" placeholder="Описание" v-model="description" />' +
            '<input type="number" placeholder="Цена" v-model="price" />' +
            '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function() {
            var message = { description: this.description,
                            price:this.price
            };

            if (this.id) {
                itemApi.update({id: this.id}, message).then(result =>
                    result.json().then(data => {
                        var index = getIndex(this.messages, data.id);
                        this.messages.splice(index, 1, data);
                        this.description = '';
                        this.price = '';
                        this.id = ''
                    })
                )
            } else {
                itemApi.save({}, message).then(result =>
                    result.json().then(data => {
                        this.messages.push(data)
                        this.description = '';
                        this.price = '';
                    })
                )
            }
        }
    }
});

Vue.component('message-row', {
    props: ['message', 'editMethod', 'messages'],
    template: '<div>' +
                '<tr>' +
                    '<th>{{ message.id }}</th>' +
                    '<td>{{ message.description }}</td>' +
                    '<td>{{ message.price }}</td>' +
                    '<span style="position: absolute; right: 0">' +
                    '<input type="button" value="Edit" @click="edit" />' +
                    '<input type="button" value="X" @click="del" />' +
                    '</span>' +
                '</tr>' +
            '</div>',
    methods: {
        edit: function() {
            this.editMethod(this.message);
        },
        del: function() {
            itemApi.remove({id: this.message.id}).then(result => {
                if (result.ok) {
                    this.messages.splice(this.messages.indexOf(this.message), 1)
                }
            })
        }
    }
});

Vue.component('messages-list', {
    props: ['messages', 'users', 'orders'],
    data: function() {
        return {
            message: null,
            item : true,
            user : false,
            order : false
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
            '<message-form :messages="messages" :messageAttr="message" v-if="item"/>' +

            '<table border="2" width="100%" cellpadding="5">' +
                '<message-row v-for="message in messages" :key="message.id" :message="message" ' +
                ':editMethod="editMethod" :messages="messages" v-if ="item"/>' +

            '</table>' +
            '<input type="button" value="Сделать заказ" @click="toOrder" />' +
            '<input type="button" value="Добавить пользователя" @click="toAddUser" /> '+
        '</div>',
    created: function() {
        itemApi.get().then(result =>
            result.json().then(data =>
                data.forEach(message => this.messages.push(message))
            )
        )
    },
    methods: {
        editMethod: function(message) {
            this.message = message;
        },
        toOrder: function () {
            this.item = false;
            this.order = true;
            this.user = false;
            orderApi.get().then(result =>
                result.json().then(data =>
                    data.forEach(message => this.messages.push(message))
                )
            )
        },
        toAddUser: function () {
            this.item = false;
            this.order = false;
            this.user = true;
            userApi.get().then(result =>
                result.json().then(data =>
                    data.forEach(message => this.messages.push(message))
                )
            )
        }
    }
});

var app = new Vue({
    el: '#app',
    template: '<messages-list :messages="messages" :users = "users":orders = "orders"/>',
    data: {
        users:[],
        messages: [],
        orders: []
    }
});

