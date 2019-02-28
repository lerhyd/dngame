<template>
    <div>
      <Header></Header>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <section class="main-section">
        <div class="wrapper">
          <div><img src="../../assets/img/dn_logo.jpg" style="width: 35%"/></div>
          <form  id="recovery-form" @submit.prevent="enter">
            <fieldset class="email">
              <input class="form-input" type="email" v-model="email" placeholder="Почта" required>
            </fieldset>
            <router-link to="/contacts" id="help">Не получилось?</router-link>
            <div>
              <button type="submit" class="submit"><a>Восстановить</a></button>
            </div>
            <p id="fail-message">
              <a v-if="this.$store.getters.forgotStatus == 1">Пользователя с таким адресом электронной почты у нас нет</a>
              <a v-if="this.$store.getters.forgotStatus == 2">Адрес электронной почты введен неверно</a>
              <a v-if="this.$store.getters.forgotStatus == 3">User does not have role 'user'</a>
            </p>
          </form>
        </div>

      </section>

    </div>
</template>

<script>
    import Header from "@/components/main/Header";
    export default {
        name: "NewForgot",
      components: {Header},
      data (){
        return {
          email: ''
        }
      },

      methods: {
        enter () {
          this.$store.dispatch('forgot', {email: this.email}).then();
        }
      }
    }
</script>

<style scoped>

  div img {
    border-radius: 70px;
    margin-bottom: 110px;
    -webkit-box-shadow: 2px 2px 5px 0px rgb(0, 0, 0);
    -moz-box-shadow: 2px 2px 5px 0px rgb(0, 0, 0);
    box-shadow: 0px 0px 50px 30px rgb(0, 0, 0);

  }

  #recovery-form{
    display: inherit;
    padding-bottom: 5%;
  }

  #fail-message{
    font-family: 'Hand';
    color: #ff2438;
    font-size: large;
  }

  #help{
    font-family: 'Hand';
    color: white;
  }

  .wrapper{
    display: inline-block;
    position: center;
    height: 90%;
    width: 60%;
    /*border: 5px solid rgb(254, 254, 254);*/
    border-radius: 10px;
  }

  fieldset.email::after {content: '\f003';}

  .submit{
    height: 40px;
    display: inline;
    width: 200px;
    margin-top: 30px;
    cursor: pointer;
    font-family: 'Hand';
    font-size: large;
    color: #111111;
    border-radius: 6px;
    border: 1px solid #fdfefd;
    user-focus: none;
    background: whitesmoke;
    outline: none;
    margin-bottom: 30px;
  }

  .submit:hover a {
    font-size: 17px;
    mix-blend-mode: multiply;
  }

  .form-input{
    font-family: 'Hand';
    color: white;
    width: 270px;
    height: 35px;
    border-radius: 10px;
    border: 1px solid white;
    user-focus: none;
    background: none;
    outline: none;
    margin-top: 10px;
    font-size: 20px;
    transition: all 0.5s linear;
  }

  .form-input:hover{
    background: rgb(222, 222, 222);
    box-shadow: 0 0 300px 1px #c0c0c0;
    border: 1px solid #474A59;
    color: #111111;
  }

  .form-input:hover::placeholder{
    color: #111111;
  }

  ::placeholder {color: white;}

  .form-input::selection{
    color: white;
    background: #474A59;
  }

  .form-input:focus::placeholder{
    color: transparent;
  }

  fieldset {
    border: none;
    position: relative;
    height: 35px;
    alignment: center;
    margin-bottom: 10px;
  }

  fieldset::after {
    font-family: FontAwesome;
    position: absolute;
    right: 9%;
    top: 53%;
    text-align: center;
    color: #880807;
  }


  .main-section{
    width: 45%;
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
  }

  @media screen and (max-width: 700px){

    #recovery-form{width: 100%;}

    .wrapper{
      width: 90%;
      border: 5px solid rgb(254, 254, 254);
      border-radius: 10px;
    }

    .wrapper ul{width: auto;}

    .main-section{width: 90%;}

    fieldset::after{right: 10%;}

    section img{display: none;}
  }

  @media screen and (min-width:701px) and (max-width: 1209px){

    div img{
      margin-top: 30px;
      margin-bottom: 90px;
    }

    .main-section{width: 95%;}
  }


</style>
