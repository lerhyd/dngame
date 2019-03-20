<template>
    <div>
      <div v-if="this.$store.getters.gameClassChooseStatus!=0">
        <p>
          Идёт поиск противника...
        </p>
      </div>
      <div v-if="this.$store.getters.gameClassChooseStatus == 0">
        <p>
          Противник найден!
        </p>
      </div>
    </div>
</template>

<script>
    export default {
        name: "Area"
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
