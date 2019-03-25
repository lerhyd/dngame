<template>
    <div>
      <span id="user-data-main">
          <!--<p>{{this.$store.getters.user.login}}Тут логин</p>-->
          <h3 id="nick">{{this.$store.getters.user.login}}</h3>
        <div id="game-info" v-for="status in this.$store.getters.status">
        <!--<div id="game-info">-->
          <a>Очки: </a>{{status.points}}
          <br><br>
          <a>Уровень: </a>{{status.lvl}}
          <br><br>
          <a>Звание: </a>{{status.rank}}
          <br><br>
          <div v-if="this.$store.getters.isKira">
            <a >Убийств: </a>{{status.numberOfRightKills}}
          </div>
          <div v-if="!this.$store.getters.isKira">
            <a>Поймано убийц: </a>{{status.numberOfCaughtKillers}}
          </div>
        </div>
      </span>
    </div>
</template>

<script>
    export default {
        name: "UserData"
    }
</script>

<style scoped>
  #user-data-main{
    position: absolute;
    right: 5px;
    top: 85px;
    text-align: right;
    color: white;
    font-family: 'Hand';

  }

  #nick{
    margin-top: 0;
    color: #880000;
    font-size: x-large;
  }

  #game-info a{
    color: #880000;
    font-size: large;
    text-transform: uppercase;

  }

</style>
