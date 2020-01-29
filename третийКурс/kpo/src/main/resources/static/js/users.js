const users = Vue.resource('/users/{id}')

export default {
    getByUserId: userId => users.getById({id}),
    add: user => users.save({}, user),
    update: user => users.update({id: users.id}, users),
    remove: id => users.remove({id}),
}