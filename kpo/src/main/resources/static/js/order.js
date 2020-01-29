const orders = Vue.resource('/order/{id}')

export default {
    getById: orderId => orders.get({id}),
    add: item => itemApi.post({id}),
    save: user => orders.put({}, user),
    delete: id => orders.delete({id}),
}