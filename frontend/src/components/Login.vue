<template>
  <div>
    <div class="social">
      <div class="google">
        <img src="../assets/img/google_logo.png" alt="google">
        <a href="#">LOG IN WITH GOOGLE</a>
      </div>
      <div class="vk">
        <img src="../assets/img/vk_logo.png" alt="vk">
        <a href="#">LOG IN WITH VKONTAKTE</a>
      </div>
    </div>
    <p>or</p>
    <form @submit.prevent="enter">
      <label>
        Login:
        <input type="text" v-model="login">
      </label>
      <br>
      <label>
        Password:
        <input type="password" v-model="pass"/>
      </label>
      <br>
      <!--
      <p style="color: red" v-if="$store.state.failedLogin">Incorrect credentials</p>
      -->
      <input class="sub" type="submit" value="Log in"/>
    </form>
    <div class="link" >
      <a href="#">Sign up</a>
    </div>
  </div>
</template>

<script>
    export default {
      name: "Login",
      data (){
        return {
          login: '',
          pass: ''
        }
      },
      methods: {
        enter () {
          //this.$store.dispatch('login', {login: this.login, password: this.pass}).then();
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
  }

  form {
    margin-top: -5px;
  }

  form label{
    color: #FFF352;
    font-weight: bold;
    font-size: 25px;
    font-family: Roboto;
  }

  form label:first-child {
    margin-left: 45px;
    margin-bottom: 50px;
  }

  form input {
    height: 25px;
    width: 180px;
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
  }

  .link a:hover {
    color: #EFEFEA;
    background-color: crimson;
  }


</style>
