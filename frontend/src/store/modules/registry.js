import axios from 'axios'
import router from "../../router";

export default {
  state: {
    regDate: [],
    failed: false,
<<<<<<< HEAD
    registryStatus: 0
=======
    errorStatus: 0
>>>>>>> CO8ECTb-master
  },

  mutations: {
    setLogin (state, list) {
      state.login = list;
    },
    setFailed (state, data) {
      state.failed = data;
    },
    setStatus (state, status){
<<<<<<< HEAD
      state.registryStatus = status;
=======
      state.errorStatus = status;
>>>>>>> CO8ECTb-master
    }
  },

  getters: {
    failed: state => state.failed,
<<<<<<< HEAD
    registryStatus: state => state.registryStatus
=======
    errorStatus: state => state.errorStatus
>>>>>>> CO8ECTb-master
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
<<<<<<< HEAD
        console.log(response.data)
        if (response.data != 0){
          context.commit('setStatus', response.data);
          router.push("/registry")
        } else {
          context.commit('setStatus', response.data);
          router.push("/confirm")
        }
=======
        if (response.data !== 0){
          context.commit('setStatus', response.data);
          console.log(response.data)
          router.push("/registry")
        }
        if (response.data == 0)
          console.log(response.data)
          router.push("/confirm")

>>>>>>> CO8ECTb-master
      })
        .catch(error => {
          context.commit('setFailed', true);
        })
    }
  }

}
