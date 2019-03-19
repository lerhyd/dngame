<template>
    <div id="app">
      <header>
        <div style="cursor: default;">Death Note</div>
        <div>
          {{checkIfLogged()}}
          {{checkIfLoggedIn()}}
          {{checkIfConfirmed()}}
          <router-link class="button16" to="/" @click="checkIfLogged();checkIfConfirmed()">Главная</router-link>
          <router-link class="button16" to="/about" @click="checkIfLogged();checkIfConfirmed()">О проекте</router-link>
          <router-link class="button16" to="/login" @click="checkIfLogged();checkIfConfirmed()" v-if="!this.$store.getters.logged">Войти</router-link>
          <router-link class="button16" to="/registry" @click="checkIfLogged();checkIfConfirmed()" v-if="!this.$store.getters.logged">Зарегистрироваться</router-link>
          <router-link class="button16" to="/game" @click="checkIfLogged();checkIfConfirmed()" v-if="this.$store.getters.logged && this.$store.getters.loginStatus">В игру</router-link>
          <router-link class="button16" to="/achievements" @click="checkIfLogged();checkIfConfirmed()" v-if="this.$store.getters.logged && this.$store.getters.loginStatus">Мои достижения</router-link>
          <router-link class="button16" to="/settings" @click="checkIfLogged();checkIfConfirmed()" v-if="this.$store.getters.logged && this.$store.getters.loginStatus">Настройки</router-link>
          <a class="button16" href="/logout" @click="checkIfLogged();checkIfConfirmed()" v-if="this.$store.getters.logged">Выйти</a>
        </div>
      </header>
    </div>
</template>

<script>
    export default {
        name: "Header",
        methods: {

          checkIfLogged (){
            this.$store.dispatch('checkIfLogged').then();
          },
          checkIfLoggedIn (){
            this.$store.dispatch('checkIfLoggedIn').then();
          },
          checkIfConfirmed (){
            this.$store.dispatch('checkIfConfirmed').then();
          }
        }
    }
</script>

<style scoped>

  @font-face {
    font-family: 'DeathNote';
    src: local('DeathNote'),
    url('../../assets/fonts/alegreyasans/DEATHNOTEFont.ttf') format('truetype');
    font-weight: 400;
    font-style: normal;
  }

  @font-face {
    font-family: 'Hand';
    src: local('Hand'),
    url('../../assets/fonts/alegreyasans/14310.ttf') format('truetype');
    font-weight: 400;
    font-style: normal;
  }

  .button16 {
    display: inline-block;
    text-decoration: none;
    padding: 1em;
    outline: none;
    border-radius: 10px;
    font-size: medium;
    font-family: 'Hand';
    color: white;
  }
  .button16:hover {
    background-image:
      radial-gradient(3px 45% at 0% 50%, rgba(255, 255, 255, 0.6), transparent),
      radial-gradient(3px 45% at 100% 50%, rgba(255,255,255,.6), transparent);
  }
  .button16:active {
    background-image:
      radial-gradient(50% 50% at 50% 50%, rgba(74, 74, 74, 0.9), rgba(255,255,255,0));
  }

  #app{
    text-align: center;
    display:block;
    width:100%;
    height: 75px;
    font-family: 'DeathNote';
    font-size: xx-large;
  }

  @media screen and (max-width: 700px){
    #app{
      height: 45px;
      font-size: x-large;
    }

    .button16{
      padding: 0px;
      font-size: small;
    }
  }

  @media screen and (min-width:701px) and (max-width: 1209px){
    #app{
      height: 50px;
      font-size: xx-large;
    }

    .button16{
      padding: 0.3em;
      font-size: 24px;
    }
  }
</style>
