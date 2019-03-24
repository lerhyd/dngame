<template>
  <div id="confirm-mes">
    <Header></Header>
    <section id="sendAgain-section">
      <p>Доступ к аккаунту ограничен. Подтверди почту, чтобы завершить регистрацию.</p>
      <a id="send-again-text" v-on:click="sendAgain" v-if="!isSend">Отправить потверждающее письмо еще раз?</a>
      <a v-if="isSend" id="status-ok">Отправлено!</a>
      <a>{{this.$store.getters.loginName}}</a>
    </section>
  </div>
</template>

<script>
  import Header from "@/components/main/Header";
  export default {
    name: "NotConfirmEmailMessage",
    components: {Header},
    data() {
      return{
        isSend: false
      }
    },
    methods:{
      sendAgain () {
        this.$store.dispatch('sendToken').then();
        this.isSend = true;
      }
    },
  }
</script>

<style scoped>

  @font-face {
    font-family: 'Hand';
    src: local('Hand'),
    url('../../assets/fonts/alegreyasans/14310.ttf') format('truetype');
    font-weight: 400;
    font-style: normal;
    color: white;
  }

  #status-ok{
    text-decoration: underline;
    color: green;
  }

  #confirm-mes{
    font-family: 'Hand';
    font-size: x-large;
    color: white;
  }

  #send-again-text{
    cursor: pointer;
    text-decoration: underline;
    color: #62000c;
  }

  #sendAgain-section {
    width: 50%;
    text-align: center;
    position: absolute;
    color: white;
    top: 40%;
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
  }

</style>
