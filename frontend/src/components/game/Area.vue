<template>
    <div>
      <!--killer's area-->
      <div v-if="this.$store.getters.isKira">
        {{getKiraStatus()}}
        <!--User's data-->
        <div>
          <div v-for="user in this.$store.getters.user">
            <p>{{user.login}}</p>
          </div>
          <div v-for="stat in this.$store.getters.status">
            <p>points: {{stat.points}}</p>
            <p>lvl: {{stat.lvl}}</p>
            <p>rank: {{stat.rank}}</p>
            <p>number of right kills: {{stat.numberOfRightKills}}</p>
          </div>
        </div>
        <!--News-->
        <div>

        </div>
        <!--Actions-->
        <div>

        </div>
      </div>

      <!--agent's area-->
      <div v-if="!this.$store.getters.isKira">
        {{getAgentStatus()}}
        <!--User's data-->
        <div>
          <div v-for="user in this.$store.getters.user">
            <p>{{user.login}}</p>
          </div>
          <div v-for="stat in this.$store.getters.status">
            <p>points: {{stat.points}}</p>
            <p>lvl: {{stat.lvl}}</p>
            <p>rank: {{stat.rank}}</p>
            <p>number Of Caught Killers: {{stat.numberOfCaughtKillers}}</p>
          </div>
        </div>
        <!--News-->
        <div>

        </div>
        <!--Actions-->
        <div>

        </div>
      </div>
    </div>
</template>

<script>
  export default {
    name: "Area",
    methods: {
      getKiraStatus(){
        this.$store.dispatch('getKiraStatus')
      },
      getAgentStatus(){
        this.$store.dispatch('getAgentStatus')
      },
    }
  }
</script>

<style scoped>

</style>
