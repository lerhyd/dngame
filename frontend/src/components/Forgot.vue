<template>
  <div id="recovery">
    <div class="info">
      <h1>Recovery</h1>
      <img src="../assets/img/dn_logo.jpg" alt="dn_logo">
    </div>
    <div class="recovery">
      <label class="first_label">
        Email:
        <input type="text" v-model="email">
      </label>
      <br>
      <input class="sub" type="submit" value="Send password"/>
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
        name: "Forgot"
    }
</script>

<style scoped>
  #recovery {
    font-family: 'Alegreya Sans';
    text-align: center;
    color: #EFEFEA;
    background-color: #030000;
  }

  h1 {
    font-size: 45px;
    font-family: "Droid Sans Mono";
    margin: 0 auto;
    margin-top: 0;
    width: 350px;
  }

  label {
    color: #FFF352;
    font-weight: bold;
    font-size: 25px;
    font-family: Roboto;
    margin-left:-5%;
    margin-bottom: 50px;
    margin-top: 50px;
    display: block;
  }

  input {
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

  .recovery {
    background: -webkit-linear-gradient(top, #030000, #21222c);
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
    margin-top: 170px;
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
