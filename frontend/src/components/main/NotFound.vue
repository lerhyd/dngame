<template>
  <div id="app">
    <section class="main-error-section">
      <div id="header">
        <router-link to="/" class="close-to-main"></router-link>
      </div>
      <div class="center-error-page">
        <div id="error-number">404</div>
        <div id="error-title">Page Not Found</div>
        <div id="error-text"> Упс. Что-то пошло не так.<br>Впрочем, ничего нового. Го на
          <router-link to="/" style="color: #111111; font-size: inherit">главную</router-link>?</div>
        <div><img src="../../assets/img/404_v1.png" style="width: 100%"/>
          <a>Мы сделали окно внутри окна, чтобы ты мог смотреть на страницу, которой нет, пока смотришь на
            страницу, которой нет.</a>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
    export default {
        name: "NotFound"
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


  .center-error-page{
    font-family: 'Hand';
    color: #111111;
    display: inline-block;
    position: center;
    height: 90%;
    width: 70%;
  }

  #header {
    display:block;
    width:100%;
    height:52px;
    background-color: #5c7577;
  }

  div a {
    font-size: 12px;
  }

  #error-text {
    margin-top: 5%;
    font-size: x-large;

  }

  #error-number {
    margin-top: 20px;
    margin-bottom: 10px;
    font-size: 60px;
    letter-spacing: 8px;
  }

  #error-title {
    font-size: xx-large;
    letter-spacing: 5px;
  }


  .main-error-section{
    width: 50%;
    text-align: center;
    position: absolute;
    background: #eeeeee;
    top: 50%;
    left: 50%;
    margin-bottom: 0px;
    /*border: red 1px solid;*/
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
  }

  .close-to-main {
    position: absolute;
    right: 10px;
    top: 15px;
    width: 22px;
    height: 22px;
    background: #ff1e42;
    border-radius: 5px;
    /*border: 1px red solid;*/
  }

  .close-to-main:hover {
    background: #880000;
  }

  .close-to-main:before, .close-to-main:after {
    position: absolute;
    left: 10px;
    content: ' ';
    height: 100%;
    width: 2px;
    background-color: #010000;
  }
  .close-to-main:before {
    transform: rotate(45deg);
  }
  .close-to-main:after {
    transform: rotate(-45deg);
  }

  @media screen and (max-width: 700px) {
    .main-error-section{
      width: 95%;
    }
  }

</style>
