const cardApi = Vue.resource("/card{/id}")

export default {
    save: userId => cardApi.get({id}),
    add: user => cardApi.post({}, user),
    update: user => cardApi.put({id: users.id}, users),
    remove: id => cardApi.delete({id}),
}