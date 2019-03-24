<template>
    <div>
      <Header></Header>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <section class="settings-main-section">
        <h2 id="settings-title">Изменение пароля</h2>
        <div class="settings-center">
        <form  id="registry-form" @submit.prevent="changePass">
            <fieldset class="oldPass">
              <input class="form-input" type="password" v-model="oldPass" placeholder="Старый пароль" required>
            </fieldset>
            <fieldset class="newPass">
              <input class="form-input" type="password" v-model="newPass" placeholder="Новый пароль" required>
            </fieldset>
            <fieldset class="retypeNewPass">
              <input class="form-input" type="password" v-model="retypeNewPass" placeholder="Снова введите новый пароль" required>
            </fieldset>
            <div>
              <button type="submit" class="submit-settings"><a>Сменить пароль</a></button>
            </div>
            <p id="ok-message">
              <a v-if="this.$store.getters.passwordStatus === 0 && this.status">Подтверждающее письмо<br> отправлено на почту</a>
            </p>
            <p id="fail-message" v-if="this.$store.getters.passwordStatus !== 0">
              <a v-if="this.$store.getters.passwordStatus === 2">Длина пароля меньше<br> 6 символов</a>
              <a v-if="this.$store.getters.passwordStatus === 3">Пароль содержит недопустимые символы</a>
              <a v-if="this.$store.getters.passwordStatus === 4">Пароли не совпадают</a>
              <a v-if="this.$store.getters.passwordStatus === 5">Пароль введен неверно</a>
            </p>
        </form>
        </div>
      </section>
    </div>
</template>

<script>
  import Header from "@/components/main/Header";
  export default {
    name: "Settings",
    components: {Header},
    data() {
      return {
        oldPass: '',
        newPass: '',
        retypeNewPass: '',
        status: false
      }
    },
    methods: {
      changePass(){
        this.$store.dispatch('changePass', {
          oldPass: this.oldPass,
          newPass: this.newPass,
          retypeNewPass: this.retypeNewPass
        }).then();
        this.status = true;
      }
    }
  }
</script>

<style scoped>

  #settings-title{
    font-family: 'Hand';
    color: white;
  }


  #registry-form{
    display: inherit;
    padding-bottom: 5%;
  }

  #fail-message{
    font-family: 'Hand';
    color: #ff2438;
    font-size: large;
  }

  #ok-message{
    font-family: 'Hand';
    color: green;
    font-size: large;
  }

  .settings-center{
    display: inline-block;
    position: center;
    height: 90%;
    width: 60%;
    /*border: 5px solid;*/
    /*border-image: linear-gradient(90deg, #d6d6d6 0%, #1e1e1e 100%);*/
    /*border-image-slice: 1;*/
    /*border: 5px solid rgb(254, 254, 254);*/
    /*border-radius: 30px;*/
  }

  .submit-settings{
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

  .submit-settings:hover a {
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

  fieldset.oldPass::after {content: '\f023';}

  fieldset.newPass::after {content: '\f023';}

  fieldset.retypeNewPass::after {content: '\f01e';}


  section img{
    height: auto;
    width: 100%;
  }

  .settings-main-section{
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

    .settings-center{
      width: 90%;
      border: 5px solid rgb(254, 254, 254);
      border-radius: 10px;
    }

    .settings-center ul{width: auto;}

    .settings-main-section{width: 90%;}

    fieldset::after{right: 10%;}

  }

  @media screen and (min-width:701px) and (max-width: 1209px){

    .settings-main-section{width: 95%;}
  }

</style>
