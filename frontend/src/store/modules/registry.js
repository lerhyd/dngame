import axios from 'axios'
import router from "../../router";

export default {
  state: {
    regDate: [],
    failed: false,
    errorStatus: 0
  },

  mutations: {
    setLogin (state, list) {
      state.login = list;
    },
    setFailed (state, data) {
      state.failed = data;
    },
    setStatus (state, status){
      state.errorStatus = status;
    }
  },

  getters: {
    failed: state => state.failed,
    errorStatus: state => state.errorStatus
  },

  actions: {
    signup(context, credentials){
      axios.post('/signup', {
        login: credentials.login,
        password: credentials.password,
        retypePassword: credentials.retypePassword,
        email: credentials.email
      }).then(response => {
        context.commit('setStatus', response.data);
        if (response.data !== 0){
          context.commit('setStatus', response.data);
          console.log(response.data)
          router.push("/registry")
        }
        if (response.data == 0)
          console.log(response.data)
          router.push("/confirm")

      })
        .catch(error => {
          context.commit('setFailed', true);
        })
    }
  }

}
