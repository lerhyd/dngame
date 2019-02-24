<template>
  <div id="registry">
    <div class="">
      <h1>Registration</h1>
      <img src="../assets/img/dn_logo.jpg" alt="dn_logo">
    </div>
    <div class="registry">
      <form @submit.prevent="signup">
        <label class="first_label">
          Login:
          <input type="text" v-model="login">
        </label>
        <br>
        <label class="second_label">
          Password:
          <input type="password" v-model="password"/>
        </label>
        <br>
        <label class="third_label">
          Retype password:
          <input type="password" v-model="retypePassword"/>
        </label>
        <br>
        <label class="fourth_label">
          Email:
          <input type="text" v-model="email"/>
        </label>
        <br>
        <p style="color: red" v-if="this.$store.getters.failed">Incorrect credentials</p>
        <p style="color: red" v-else-if="this.$store.getters.errorStatus == 1">
          User with the login exists {{this.$store.getters.errorStatus}}
        </p>
        <p style="color: red" v-else-if="this.$store.getters.errorStatus == 2">
          The password does not match with retype password
        </p>
        <p style="color: red" v-else-if="this.$store.getters.errorStatus == 3">
          Password's length is less than 8
        </p>
        <p style="color: red" v-else-if="this.$store.getters.errorStatus == 4">
          Password contains non-Latin letters
        </p>
        <input class="sub" type="submit" value="Sign up"/>
      </form>
      <div class="link">
        <router-link to="/">Return to welcome page</router-link>
      </div>
      <footer>
        <div class="container">
          <a href="#">Our contacts</a>
        </div>
      </footer>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Registry",
    data (){
      return {
        login: '',
        password: '',
        retypePassword: '',
        email: ''
      }
    },
    methods: {
      signup () {
        this.$store.dispatch('signup', {
          login: this.login,
          password: this.password,
          retypePassword: this.retypePassword,
          email: this.email
        }).then()
      }
    }
  }
</script>

<style scoped>
  #registry {
    font-family: 'Alegreya Sans';
    text-align: center;
    color: #EFEFEA;
    background-color: #030000;
  }

  .registry {
    background: -webkit-linear-gradient(top, #030000, #21222c);
    height: 410px;
  }

  h1 {
    font-size: 45px;
    font-family: "Droid Sans Mono";
    margin: 0 auto;
    margin-top: 0;
    width: 350px;
  }

  form label{
    color: #FFF352;
    font-weight: bold;
    font-size: 25px;
    font-family: Roboto;
    margin-left: -8%;
    margin-bottom: 50px;
    margin-top: 50px;
    display: block;
  }

  .first_label {
    margin-bottom: -45px;
    margin-left: -5%;
  }

  .second_label {
    margin-bottom: -45px;
  }

  .third_label {
    margin-bottom: -45px;
    margin-left: -13%;
  }

  .fourth_label {
    margin-bottom: 10px;
    margin-left: -5%;
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
    padding: 8px 30px;
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

  footer {
    margin-top: 25px;
    padding-top: 10px;
    height: 35px;
    background-color: #4e4e65;
  }

  footer:hover {
    background: #000;
  }

  footer a {
    text-decoration: none;
    font-family: "DejaVu Sans Condensed";
    color: #EFEFEA;
    font-size: 23px;
    font-weight: bold;
  }

  footer a:hover {
    color: yellow;
  }

</style>
