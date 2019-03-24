<template>
    <div>
      <Header></Header>
      <section class="findmatch-main-section">
        <div class="findmatch-center-on-page">
          <div v-if="this.$store.getters.gameClassChooseStatus!=0 || this.$store.getters.gameClassChooseStatus!=3">
            <p>
              Идёт поиск противника...
            </p>
            <div class="cssload-thecube">
              <div class="cssload-cube cssload-c1"></div>
              <div class="cssload-cube cssload-c2"></div>
              <div class="cssload-cube cssload-c4"></div>
              <div class="cssload-cube cssload-c3"></div>
            </div>
          </div>
          <div v-if="this.$store.getters.gameClassChooseStatus == 0">
            <p>
              Противник найден!
              {{goToArea()}}
            </p>
          </div>
          <div v-if="this.$store.getters.gameClassChooseStatus == 3">
            <p>
              Ты уже учавствуешь в матче
              <button class="findmatch-reset">
              <router-link to="/area" ><a>Перезайти</a></router-link>
              </button>
            </p>
          </div>
        </div>
      </section>
    </div>
</template>

<script>
  import router from "@/router";
  import Header from "@/components/main/Header";
  export default {
    name: "Area",
    components: {Header},
    methods: {
      goToArea(){
        if (this.$store.getters.gameClassChooseStatus == 0) {
          console.log("перенаправление")
          router.push("/area")
        }
      }
    }
  }
</script>

<style scoped>

  .findmatch-reset{
    height: 40px;
    display: inline;
    width: 200px;
    margin-top: 15px;
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

  .findmatch-reset a{
    text-decoration: none;
    color: #111111;
  }

  .findmatch-reset:hover a {
    font-size: 17px;
    mix-blend-mode: multiply;
  }

  .cssload-thecube {
    width: 36px;
    height: 36px;
    margin: 0 auto;
    margin-top: 24px;
    position: relative;
    transform: rotateZ(45deg);
    -o-transform: rotateZ(45deg);
    -ms-transform: rotateZ(45deg);
    -webkit-transform: rotateZ(45deg);
    -moz-transform: rotateZ(45deg);
  }
  .cssload-thecube .cssload-cube {
    position: relative;
    transform: rotateZ(45deg);
    -o-transform: rotateZ(45deg);
    -ms-transform: rotateZ(45deg);
    -webkit-transform: rotateZ(45deg);
    -moz-transform: rotateZ(45deg);
  }
  .cssload-thecube .cssload-cube {
    float: left;
    width: 50%;
    height: 50%;
    position: relative;
    transform: scale(1.1);
    -o-transform: scale(1.1);
    -ms-transform: scale(1.1);
    -webkit-transform: scale(1.1);
    -moz-transform: scale(1.1);
  }
  .cssload-thecube .cssload-cube:before {
    content: "";
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgb(136,0,0);
    animation: cssload-fold-thecube 2.28s infinite linear both;
    -o-animation: cssload-fold-thecube 2.28s infinite linear both;
    -ms-animation: cssload-fold-thecube 2.28s infinite linear both;
    -webkit-animation: cssload-fold-thecube 2.28s infinite linear both;
    -moz-animation: cssload-fold-thecube 2.28s infinite linear both;
    transform-origin: 100% 100%;
    -o-transform-origin: 100% 100%;
    -ms-transform-origin: 100% 100%;
    -webkit-transform-origin: 100% 100%;
    -moz-transform-origin: 100% 100%;
  }
  .cssload-thecube .cssload-c2 {
    transform: scale(1.1) rotateZ(90deg);
    -o-transform: scale(1.1) rotateZ(90deg);
    -ms-transform: scale(1.1) rotateZ(90deg);
    -webkit-transform: scale(1.1) rotateZ(90deg);
    -moz-transform: scale(1.1) rotateZ(90deg);
  }
  .cssload-thecube .cssload-c3 {
    transform: scale(1.1) rotateZ(180deg);
    -o-transform: scale(1.1) rotateZ(180deg);
    -ms-transform: scale(1.1) rotateZ(180deg);
    -webkit-transform: scale(1.1) rotateZ(180deg);
    -moz-transform: scale(1.1) rotateZ(180deg);
  }
  .cssload-thecube .cssload-c4 {
    transform: scale(1.1) rotateZ(270deg);
    -o-transform: scale(1.1) rotateZ(270deg);
    -ms-transform: scale(1.1) rotateZ(270deg);
    -webkit-transform: scale(1.1) rotateZ(270deg);
    -moz-transform: scale(1.1) rotateZ(270deg);
  }
  .cssload-thecube .cssload-c2:before {
    animation-delay: 0.285s;
    -o-animation-delay: 0.285s;
    -ms-animation-delay: 0.285s;
    -webkit-animation-delay: 0.285s;
    -moz-animation-delay: 0.285s;
  }
  .cssload-thecube .cssload-c3:before {
    animation-delay: 0.57s;
    -o-animation-delay: 0.57s;
    -ms-animation-delay: 0.57s;
    -webkit-animation-delay: 0.57s;
    -moz-animation-delay: 0.57s;
  }
  .cssload-thecube .cssload-c4:before {
    animation-delay: 0.855s;
    -o-animation-delay: 0.855s;
    -ms-animation-delay: 0.855s;
    -webkit-animation-delay: 0.855s;
    -moz-animation-delay: 0.855s;
  }



  @keyframes cssload-fold-thecube {
    0%, 10% {
      transform: perspective(66px) rotateX(-180deg);
      opacity: 0;
    }
    25%,
    75% {
      transform: perspective(66px) rotateX(0deg);
      opacity: 1;
    }
    90%,
    100% {
      transform: perspective(66px) rotateY(180deg);
      opacity: 0;
    }
  }

  @-o-keyframes cssload-fold-thecube {
    0%, 10% {
      -o-transform: perspective(66px) rotateX(-180deg);
      opacity: 0;
    }
    25%,
    75% {
      -o-transform: perspective(66px) rotateX(0deg);
      opacity: 1;
    }
    90%,
    100% {
      -o-transform: perspective(66px) rotateY(180deg);
      opacity: 0;
    }
  }

  @-ms-keyframes cssload-fold-thecube {
    0%, 10% {
      -ms-transform: perspective(66px) rotateX(-180deg);
      opacity: 0;
    }
    25%,
    75% {
      -ms-transform: perspective(66px) rotateX(0deg);
      opacity: 1;
    }
    90%,
    100% {
      -ms-transform: perspective(66px) rotateY(180deg);
      opacity: 0;
    }
  }

  @-webkit-keyframes cssload-fold-thecube {
    0%, 10% {
      -webkit-transform: perspective(66px) rotateX(-180deg);
      opacity: 0;
    }
    25%,
    75% {
      -webkit-transform: perspective(66px) rotateX(0deg);
      opacity: 1;
    }
    90%,
    100% {
      -webkit-transform: perspective(66px) rotateY(180deg);
      opacity: 0;
    }
  }

  @-moz-keyframes cssload-fold-thecube {
    0%, 10% {
      -moz-transform: perspective(66px) rotateX(-180deg);
      opacity: 0;
    }
    25%,
    75% {
      -moz-transform: perspective(66px) rotateX(0deg);
      opacity: 1;
    }
    90%,
    100% {
      -moz-transform: perspective(66px) rotateY(180deg);
      opacity: 0;
    }
  }

  .findmatch-main-section{
    width: 50%;
    text-align: center;
    position: absolute;
    top: 50%;
    left: 50%;
    -moz-transform: translateX(-50%) translateY(-50%);
    -webkit-transform: translateX(-50%) translateY(-50%);
    transform: translateX(-50%) translateY(-50%);
  }

  .findmatch-center-on-page{
    font-family: 'Hand';
    font-size: xx-large;
    color: white;
    display: inline-block;
    position: center;
    height: 90%;
    width: 90%;
    border-radius: 15px;
    /*border: 5px solid white;*/
  }


  @media screen and (max-width: 700px){
    .findmatch-main-section{
      width: 99%;
    }

    .findmatch-center-on-page{
      width: 95%;
      font-size: x-large;
    }

  }
</style>
