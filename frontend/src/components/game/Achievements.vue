<template>
  <div>
    <Header></Header>
    <section id="achieve-main-section">
      <div> <!-- Пропиши тут v-for цикл для ачивок. В title достижение-->
        <!--<div v-if="this.$store.getters.kiraAchievements === 0">-->
          <!--У тебя пока нет достижений. Ничего страшного, скоро все будет )-->
        <!--</div>-->
        <!--<div v-for="achieve in this.$store.getters.kiraAchievements">-->
          <!--<Achievement title="{{achieve.title}} {{achieve.task}} {{achieve.desc}}"></Achievement>-->
        <!--</div>-->
        <!--<div v-for="achieve in this.$store.getters.agentAchievements">-->
          <!--<Achievement title="{{achieve.title}} {{achieve.task}} {{achieve.desc}}"></Achievement>-->
        <!--</div>-->
      </div>
    </section>
  </div>
</template>

<script>
  import Achievement from "@/components/game/Achievement";
  import Header from "@/components/main/Header";
  export default {
    name: "Achievements",
    components: {Header, Achievement},
    methods: {
      getKiraAchievements(){
        this.$store.dispatch('getKiraAchievements')
      },
      getAgentAchievements(){
        this.$store.dispatch('getAgentAchievements')
      }
    },
    mounted() {
      this.getKiraAchievements
      this.getAgentAchievements
    }
  }
</script>

<style scoped>
  #achieve-main-section{
    width: 100%;
    text-align: center;
    position: absolute;
  }

</style>
