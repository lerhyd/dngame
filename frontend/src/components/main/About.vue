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
              <tr>Правила игры</tr>
              <tr>Правила Тетради Смерти</tr>
              <tr>Что это вообще такое?</tr>
              <tr>Кто вы такие?</tr>
              <tr>А зачем?</tr>
            </td>
            <td id="second-row">
              <tr colspan="5">
                <a>3</a>
                <a v-if="state == 5"> Хороший вопрос. Когда мы найдем на него ответ, то обязательно вам сообщим!</a>
              </tr>
            </td>
          </table>
          </div>
        </div>
      </section>
      <section class="right-section">
      </section>
      <button v-on:click="isActive = !isActive" >text</button>
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

  #first-row{
    width: 30%;
  }
  #second-row{
    width: 70%;
  }

  #app{
    font-family: 'Hand';
    color: white;
  }

  .main-table{
    margin-top: 5px;
    margin-bottom: 5px;
    /*font-size: 130%;*/
    width: 99%;
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
    border: 1px gray solid;
  }

  table, th, td {
    /*border: 1px solid white;*/
  }

  tr {
    border-width: 1px;
    border-style: solid;
    border-image:
      linear-gradient(
        to left,
        #585858,
        rgba(255, 255, 255, 0)
      ) 1 100%;
    border-left: transparent;
    border-right: transparent;
  }

  section{
    display: inline-block;
    width: 24%;
    text-align: center;
    /*border: 1px gray solid;*/
  }

  .wrapper{
    display: inline-block;
    position: center;
    /*height: 90%;*/
    width: 95%;
    border: 5px solid rgb(254, 254, 254);
    border-radius: 30px;
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
