import axios from 'axios'

export default {
  state: {
    regData: [],

  },

  mutations: {
    setLogin (state, list) {
      state.login = list;
    }
  },

  actions: {
    signup(context, credentials){
      axios.post('/signup', {
        login: credentials.login,
        password: credentials.password,
        retypePassword: credentials.retypePassword,
        email: credentials.email
      }).then(response => {
        console.log(response);
      })
        .catch(error => {
          console.log(error);
        })
    }
  }

}
