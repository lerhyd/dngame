import axios from 'axios'
import router from "../../router";

export default {
  state: {
    regDate: [],
    failed: false,
    registryStatus: 0
  },

  mutations: {
    setLogin (state, list) {
      state.login = list;
    },
    setFailed (state, data) {
      state.failed = data;
    },
    setStatus (state, status){

      state.registryStatus = status;
    }
  },

  getters: {
    failed: state => state.failed,
    registryStatus: state => state.registryStatus
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

        console.log(response.data)
        if (response.data != 0){
          context.commit('setStatus', response.data);
          router.push("/registry")
        } else {
          context.commit('setStatus', response.data);
          router.push("/confirm")
        }
      })
        .catch(error => {
          context.commit('setFailed', true);
        })
    }
  }

}
