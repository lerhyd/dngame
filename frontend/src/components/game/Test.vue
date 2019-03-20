<template>
    <div>
      {{getPeople()}}
      <select>
        <option v-for="item in items">{{item.name}}</option>
      </select>
    </div>
</template>

<script>
    export default {
        name: "Test",
      data() {
        return {
          items: null,
        }
      },
      methods: {
        getPeople(){
          this.$store.dispatch('getRandomPeople').then();
          this.items = this.$store.getters.criminalPeople;
        }
      },
      mounted() {
        this.getPeople();
      }
    }
</script>

<style scoped>

</style>
