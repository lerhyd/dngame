<template>
    <div id="confirm-mes">
      <section>
        <p>
          На почту отправлено подтверждающее письмо. Подтверди почту, чтобы завершить регистрацию.
        </p>
        <router-link to="/" id="to-main">На главную страницу</router-link>
        <p>
          Автоматическое перенаправление через:  <a id="time">{{timeS}}</a>
        </p>
      </section>
    </div>
</template>

<script>
  import router from '@/router/index';
    export default {
        name: "Confirm",
      data() {
          return{
            timeS: 8
          }
      },
      methods:{
        setTimeStep: function(){
          let self = this;
          setTimeout(function () {
            if (self.timeS > 0) {
              self.timeS--;
              self.setTimeStep();
            }
          },1000);
         }
      },
      created(){
        this.setTimeStep();
        setTimeout(function () {router.push({ path: '/'});},9000);
      }

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

  #confirm-mes{
    font-family: 'Hand';
    font-size: x-large;
    color: white;
  }

  #to-main{
    color: white;
  }

  #time{
    color: #880000;
  }

  section {
    width: 50%;
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
  }

</style>
