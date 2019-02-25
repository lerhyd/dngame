<template>
  <div>
    <div class="social">
      <div class="google">
        <img src="../../assets/img/google_logo.png" alt="google">
        <a href="http://localhost:1234/login/google" @click="checkIfLoggedIn()">LOG IN WITH GOOGLE</a>
      </div>
      <div class="vk">
        <img src="../../assets/img/vk_logo.png" alt="vk">
        <a href="http://localhost:1234/login/vk" @click="checkIfLoggedIn()">LOG IN WITH VKONTAKTE {{checkIfLoggedIn()}}</a>
      </div>
    </div>
    <p>or</p>
    <form @submit.prevent="enter">
      <label class="first_label">
        Login:
        <input type="text" v-model="username">
      </label>
      <br>
      <label class="second_label">
        Password:
        <input type="password" v-model="password"/>
      </label>
      <br>
      <div class="forgot_link" >
        <router-link to="/recovery">Forgot password?</router-link>
      </div>
      <p style="color: red" v-if="this.$store.getters.isFailed">Incorrect credentials</p>
      <input class="sub" type="submit" value="Log in"/>
    </form>
    <div class="link" >
      <router-link to="/registry">Sign up</router-link>
    </div>
  </div>
</template>

<script>

  export default {
    name: "Login",
    data (){
      return {
        username: '',
        password: ''
      }
    },
    methods: {
      enter () {
        this.$store.dispatch('signIn', {username: this.username, password: this.password}).then();
        this.$store.commit('setLogin', {username: this.username, password: this.password});
      },

      checkIfLoggedIn (){
        this.$store.dispatch('checkIfLoggedIn').then();
      }
    }
  }
</script>

<style scoped>
  .social {
    padding-top: 10px;
    width: 260px;
    height: 100px;
    margin-left: 35.5%;
    padding-bottom: 0;
  }

  .social img {
    width: 35.5px;
    height: 35.5px;
    float: left;
  }

  .social a {
    text-decoration: none;
    font-family: Roboto;
    font-weight: bold;
    font-size: 18px;
    color: #EFEFEA;
    float: right;
  }

  .google {
    background-color: #4285F4;
    height: 40px;
    border: 2px solid black;
  }
  
  .google:hover {
    background-color: coral;
  }
  
  .google img {
    background-color: #fff;
  }

  .google a {
    margin-right: 22px;
    margin-top: 5px;
  }

  .vk {
    margin-top: 15px;
    background-color: #00324d;
    height: 40px;
    border: 2px solid black;
  }

  .vk:hover {
    background-color: blueviolet;
  }

  .vk img {
    background-color: #2E5DAB;
  }

  .vk a {
    margin-right: 5px;
    margin-top: 5px;
  }

  p {
    color: #FFF352;
    font-weight: bold;
    font-size: 20px;
    margin-left: -1%;
  }

  form {
    margin-top: -5px;
  }

  form label{
    color: #FFF352;
    font-weight: bold;
    font-size: 25px;
    font-family: Roboto;
    margin-left: -8%;
    margin-bottom: 50px;
  }

  .first_label {
    display: block;
    margin-bottom: -7px;
  }

  .second_label {
    margin-left: -13%;
    margin-top: 15px;
  }

  form input {
    height: 25px;
    width: 250px;
    border: 3px solid #EA5323;
  }

  .sub {
    margin-top: 30px;
    height: 40px;
    width: 255px;
    border: 0;
    background-color: yellow;
    color: black;
    font-size: 17px;
    font-weight: bold;
    margin-bottom: 20px;
  }

  .sub:hover {
    color: #EFEFEA;
    background-color: crimson;
  }

  .link a {
    padding: 8px 97px;
    text-decoration: none;
    font-family: Roboto;
    font-weight: bold;
    font-size: 18px;
    background-color: yellow;
    color: black;
    margin-bottom: 20px;
  }

  .link a:hover {
    color: #EFEFEA;
    background-color: crimson;
  }

  .forgot_link a{
    color: #FFF352;
    display: inline;
  }

</style>
