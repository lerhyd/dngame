<template>
    <div id="app">
      <header>
        <div>Death Note</div>
        <div>
          <router-link class="button16" to="/main">Главная</router-link>
          <router-link class="button16" to="/about">О проекте</router-link>
          <router-link class="button16" to="/login" v-if="!this.$store.getters.logged">Войти</router-link>
          <router-link class="button16" to="/registry" v-if="!this.$store.getters.logged">Зарегистрироваться</router-link>
          <router-link class="button16" to="/game" v-if="this.$store.getters.logged">В игру!</router-link>
          <router-link class="button16" to="/achievements" v-if="this.$store.getters.logged">Мои достижения</router-link>
          <router-link class="button16" to="/settings" v-if="this.$store.getters.logged">Настройки</router-link>
          <router-link class="button16" to="/logOut" v-if="this.$store.getters.logged">Выйти</router-link>
        </div>
      </header>
    </div>
</template>

<script>
    export default {
        name: "Header"
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
    /*border: 3px solid red;*/
    display:block;
    width:100%;
    height: 75px;
    min-height: 10%;
    max-height: 10%;
    font-family: 'DeathNote';
    font-size: xx-large;
  }
</style>
