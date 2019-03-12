<template>
    <div id="app">
      <Header></Header>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <section class="left-section">
      </section>
      <section class="main-section">
        <div class="wrapper">
          <div class="main-table">
          <table>
            <td id="first-row">
              <tr><button class="button" v-on:click="state = 1">Правила игры</button></tr>
              <tr><button class="button" v-on:click="state = 2">Правила Тетради</button></tr>
              <tr><button class="button" v-on:click="state = 3">Что это вообще такое?</button></tr>
              <tr><button class="button" v-on:click="state = 4">Кто мы такие?</button></tr>
              <tr><button class="button" v-on:click="state = 5">А зачем?</button></tr>
            </td>
            <td id="second-row">
              <tr colspan="5">
                <a v-if="state == 5"> Хороший вопрос. Когда мы найдем на него ответ, то обязательно вам сообщим!</a>
              </tr>
            </td>
          </table>
          </div>
        </div>
      </section>
      <section class="right-section">
      </section>
    </div>
</template>

<script>
    import Header from "@/components/main/Header";
    export default {
        name: "About",
      components: {Header},
      data (){
        return {
          state: 0
        }
      }
    }
</script>

<style scoped>

  .button{
    width: 100%;
    height: 60px;
    background: transparent;
    border: transparent;
    /*border-bottom: 1px red solid;*/
    outline: none;
    font-family: 'Hand';
    font-size: large;
    letter-spacing: 0;
    text-decoration: none;
    /*text-transform: uppercase;*/
    cursor: pointer;
  }

  .button:hover,
  .button:active {
    letter-spacing: 2px;
    border-top: 1px solid #111111;
    border-bottom: 1px solid #111111;
    /*font-size: x-large;*/
  }

  .button:after,
  .button:before {
    transition: all 280ms ease-in-out;
  }

  .button:hover:after,
  .button:hover:before {
    backface-visibility: hidden;
    border-color: #fff;
    transition: width 350ms ease-in-out;
    width: 70%;
  }

  .button:hover:before {
    bottom: auto;
    top: 0;
    width: 70%;
  }


  #first-row{
    width: 30%;
  }
  #second-row{
    width: 70%;
  }

  #app{
    font-family: 'Hand';
  }

  .main-table{
    margin-top: 5px;
    margin-bottom: 5px;
    /*font-size: 130%;*/
    width: 96%;
    position: center;
    display: inline-block;
    padding: 0 10px;
  }

  .main-table table {
    border-collapse: collapse;
    position: center;
    align-content: center;
    alignment: center;
    width: 100%;
    text-align: center;
    align: center;
    border: 1px #2d2d2d solid;
  }

  table, th, td {
    border: 1px solid #2d2d2d;
  }

  /*tr {*/
    /*border-width: 1px;*/
    /*border-style: solid;*/
    /*border-image:*/
      /*linear-gradient(*/
        /*to left,*/
        /*#585858,*/
        /*rgba(255, 255, 255, 0)*/
      /*) 1 100%;*/
    /*border-left: transparent;*/
    /*border-right: transparent;*/
  /*}*/

  section{
    display: inline-block;
    width: 24%;
    text-align: center;
    color: #111111;
    /*border: 1px gray solid;*/
  }

  .wrapper{
    display: inline-block;
    position: center;
    /*height: 90%;*/
    width: 99%;
    border: 5px solid rgb(254, 254, 254);
    border-radius: 30px;
    background: rgb(255, 255, 255);

  }

  section img{width: 100%;}
  .left-section{float: left;}

  .right-section{float: right;}

  .main-section{
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
