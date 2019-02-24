import axios from 'axios'

export default {
  state: {
    login: []
  },

  mutations: {
    setLogin (state, list) {
      state.login = list;
    }
  },

  actions: {
    signIn(context, credentials){
      axios("/login", {
        params: {
          username: credentials.username,
          password: credentials.password
        },
        method: 'POST'
      }).then(response => {
        console.log(response);
      })
        .catch(error => {
          console.log(error);
        })
    }

  }

}

