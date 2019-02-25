<template>
    <div id="app">
      <header>
        <div>Death Note</div>
        <div>
          <a class="button16">Главная</a>
          <a class="button16">О проекте</a>
          <a class="button16">Войти</a>
          <a class="button16">Зарегистрироваться</a>
          <a class="button16">Мои достижения</a>
          <a class="button16">В игру!</a>
          <a class="button16">Выйти</a>

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
    url('../assets/fonts/alegreyasans/DEATHNOTEFont.ttf') format('truetype');
    font-weight: 400;
    font-style: normal;
  }

  @font-face {
    font-family: 'Hand';
    src: local('Hand'),
    url('../assets/fonts/alegreyasans/14310.ttf') format('truetype');
    font-weight: 400;
    font-style: normal;
  }

  a.button16 {
    display: inline-block;
    text-decoration: none;
    padding: 1em;
    outline: none;
    border-radius: 10px;
    font-size: medium;
    font-family: 'Hand';
  }
  a.button16:hover {
    background-image:
      radial-gradient(3px 45% at 0% 50%, rgba(255, 255, 255, 0.6), transparent),
      radial-gradient(3px 45% at 100% 50%, rgba(255,255,255,.6), transparent);
  }
  a.button16:active {
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
