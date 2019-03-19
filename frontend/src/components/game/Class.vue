<template>
    <div>
      <p>
        Выберите класс, за который будете играть.
      </p>
      <select v-model="gameClass.isKira">
        <option disabled value="">Пожалуйста, выберите класс</option>
        <option v-bind:value="true">Убийца</option>
        <option v-bind:value="false">Агент</option>
      </select>
      <p>
        Выберите континент, в котором будет ваш персонаж.
      </p>
      <select class="form-control" v-model="gameRegion.continent">
        <option>Choose Continent</option>
        <option v-for="continent in this.$store.getters.continents" v-bind:value="continent">{{continent}}</option>
      </select>
      <br>
      <select class="form-control" v-model="gameRegion.country" v-if="gameRegion.continent!=null" @click="getRegionsWithCountries()">
        <option>Choose Country</option>
        <option v-for="country in this.$store.getters.countries" v-bind:value="country">{{country}}</option>
      </select>
      <br>
      <select class="form-control" v-model="gameRegion.regionId" v-if="gameRegion.country!=null" @click="getRegionsWithCities()">
        <option>Choose City</option>
        <option v-for="city in this.$store.getters.cities" v-bind:value="city">{{city}}</option>
      </select>
    </div>
</template>

<script>
  export default {
    name: "Class.vue",
    data() {
      return {
        gameClass: {
          isKira: undefined,
        },

        gameRegion: {
          regionId: null,
          country: null,
          continent: null,
          city: null
        }
      }
    },
    methods: {
      getRegionsWithContinents(){
        this.$store.dispatch('getRegionsWithContinents').then()
      },
      getRegionsWithCountries(){
        this.$store.dispatch('getRegionsWithCountries', {continent: this.gameRegion.continent}).then()
      },
      getRegionsWithCities(){
        this.$store.dispatch('getRegionsWithCities', {country: this.gameRegion.country}).then()
      },
      getRegionId(){
        this.$store.dispatch('getRegionId', {city: this.gameRegion.city}).then()
      },
      classChoose() {
        this.$store.dispatch('classChoose', {
          isKira: this.class.isKira,
          regionId: this.class.regionId
        }).then();
      }
    },
    mounted() {
      this.getRegionsWithContinents();
    }
  }
</script>

<style scoped>

  * {
    color: white;
  }

  input {
    color: black;
  }

  select {
    color: black;
  }

  .button16 {
    display: inline-block;
    text-decoration: none;
    padding: 1em;
    outline: none;
    border-radius: 10px;
    font-size: medium;
    font-family: 'Hand';
    color: white;
  }
  .button16:hover {
    background-image:
      radial-gradient(3px 45% at 0% 50%, rgba(255, 255, 255, 0.6), transparent),
      radial-gradient(3px 45% at 100% 50%, rgba(255,255,255,.6), transparent);
  }
  .button16:active {
    background-image:
      radial-gradient(50% 50% at 50% 50%, rgba(74, 74, 74, 0.9), rgba(255,255,255,0));
  }

</style>
