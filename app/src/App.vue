<template>
  <div style="text-align: center;">
    <img alt="Vue logo" src="./assets/logo.png">
  </div>

  <!--
  <HelloWorld msg="Welcome to Your Vue.js App."/>
  -->
  <Person/>

</template>

<script>
//import HelloWorld from './components/HelloWorld.vue'
import Person from './components/Person.vue'

export default {
  name: 'App',
  components: {
    Person
    //HelloWorld
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  color: #2c3e50;
  margin-top: 60px;
}
</style>
