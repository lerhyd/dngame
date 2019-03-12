<template>
  <div>
    <Header></Header>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <section class="left-section">
      <img src="../../assets/img/l.png"/>
    </section>
    <section class="main-section">
      <div class="wrapper">
        <div><img src="../../assets/img/ryuk.png" style="width: 30%"/></div>
        <form  id="registry-form" @submit.prevent="signup">
          <fieldset class="login">
            <input class="form-input" type="text" v-model="login" placeholder="Придумайте логин" required>
          </fieldset>
          <fieldset class="password">
            <input class="form-input" type="password" v-model="password" placeholder="Придумайте пароль" required>
          </fieldset>
          <fieldset class="re-password">
            <input class="form-input" type="password" v-model="retypePassword" placeholder="Повторите пароль" required>
          </fieldset>
          <fieldset class="email">
            <input class="form-input" type="email" v-model="email" placeholder="Введите почту" required>
          </fieldset>
          <div>
            <button type="submit" class="submit"><a>Зарегистрироваться</a></button>
          </div>
          <p id="fail-message">
            <a v-if="this.$store.getters.errorStatus == 1">Пользователь с таким логином уже существует</a>
            <a v-else-if="this.$store.getters.errorStatus == 2">Пароли не совпадают</a>
            <a v-else-if="this.$store.getters.errorStatus == 3">Длина пароля меньше 6 символов</a>
            <a v-else-if="this.$store.getters.errorStatus == 4">Пароль содержит недопустимые символы</a>
            <a v-else-if="this.$store.getters.errorStatus == 5">Пользователь с такий адресом почты уже существует</a>
            <a v-else-if="this.$store.getters.errorStatus == 6">Поле с почтой заполнено неверно</a>
          </p>
        </form>
      </div>

    </section>
    <section class="right-section">
      <img src="../../assets/img/k.png"/>
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

  #registry-form{
    display: inherit;
    padding-bottom: 5%;
  }

  #fail-message{
    font-family: 'Hand';
    color: #ff2438;
    font-size: large;
  }

  .wrapper{
    display: inline-block;
    position: center;
    height: 90%;
    width: 60%;
    border: 5px solid;
    border-image: linear-gradient(90deg, #d6d6d6 0%, #1e1e1e 100%);
    border-image-slice: 1;
  }

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
    box-shadow: 0 0 700px 1px #c0c0c0;
    border: 1px solid #474A59;
    color: #111111;
  }

  .form-input:hover::placeholder{
    color: #111111;
  }

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
  }

  fieldset::after {
    font-family: FontAwesome;
    position: absolute;
    right: 8%;
    top: 53%;
    text-align: center;
    color: #880807;
  }

  ::placeholder {color: white;}

  fieldset.login::after {content: '\f007';}

  fieldset.password::after {content: '\f023';}

  fieldset.re-password::after {content: '\f01e';}

  fieldset.email::after {content: '\f003';}

  .left-section{
    float: left;
    display: inline-block;
    width: 25%;
    text-align: center;
    margin-top: 1%;
    margin-bottom: 1%;
  }

  .left-section img{
    box-shadow: 0px 0px 40px 40px #ffffff;
  }
  .right-section{
    float: right;
    display: inline-block;
    width: 25%;
    text-align: center;
    margin-top: 1%;
    margin-bottom: 1%;
  }

  .right-section img{
    box-shadow: 0px 0px 40px 40px #000000;
  }

  section img{
    height: auto;
    width: 100%;
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

    #registry-form{width: 100%;}

    .wrapper{
      width: 90%;
      border: 5px solid rgb(254, 254, 254);
      border-radius: 10px;
    }

    .wrapper ul{width: auto;}

    .left-section{display: none;}

    .right-section{display: none;}

    .main-section{width: 90%;}

    fieldset::after{right: 10%;}

    section img{display: none;}
  }

  @media screen and (min-width:701px) and (max-width: 1209px){
    .left-section{display: none;}

    .right-section{display: none;}

    .main-section{width: 95%;}
  }

</style>
