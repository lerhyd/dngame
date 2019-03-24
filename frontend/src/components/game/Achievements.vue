<template>
  <div>
    <Header></Header>
    <section id="achieve-main-section">
      <div> <!-- Пропиши тут v-for цикл для ачивок. В title достижение-->
        <Achievement title="Titvk"></Achievement>
        <Achievement title="Titvk"></Achievement>
      </div>
    </section>
  </div>
</template>

<script>
  import Achievement from "@/components/game/Achievement";
  import Header from "@/components/main/Header";
  export default {
    name: "Achievements",
    components: {Header, Achievement}
  }
</script>

<style scoped>
  #achieve-main-section{
    width: 100%;
    text-align: center;
    position: absolute;
  }

</style>
