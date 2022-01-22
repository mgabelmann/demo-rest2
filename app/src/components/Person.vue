<template>
  <Card style="width:50rem;">
    <template #title>
      {{fullName}}
    </template>
    <template #content>
      <div class="grid">
        <div class="col-6">
          <span class="p-float-label">
            <InputText id="firstname" type="text" v-model="person.firstName"/>
            <label for="firstname">First Name</label>
          </span>
        </div>
        <div class="col-6">
          <span class="p-float-label">
            <InputText id="lastname" type="text" v-model="person.lastName"/>
            <label for="lastname">Last Name</label>
          </span>
        </div>
        <div class="col-6">
          <span class="p-float-label">
            <InputText id="middlename" type="text" v-model="person.middleName"/>
            <label for="middlename">Middle Name</label>
          </span>
        </div>
        <div class="col-6">
          <span class="p-float-label">
            <InputText id="birthdt" type="text" v-model="person.birthDt"/>
            <label for="birthdt">Birth Date</label>
          </span>
        </div>
        <div class="col-6">
          <span class="p-float-label">
            <InputText id="sex" type="text" v-model="person.sex"/>
            <label for="sex">Sex</label>
          </span>
        </div>
      </div>
    </template>
  </Card>
</template>

<script>
import Card from 'primevue/card'
import InputText from 'primevue/inputtext'
import axios from 'axios';

export default {
  components: {
    Card,
    InputText,
  },
  data() {
    return {
      loading: true,

      person: {
        personId: '',
        firstName: '',
        lastName: '',
        middleName: '',
        birthDt: '',
        sex: '',
      },
    }
  },
  methods: {
    async loadPerson() {
      await axios.get('http://localhost:8080/persons/1')
          .then(response => {
            this.person = {...response.data};
            this.person.middleName = response.data.middleName == null ? '' : response.data.middleName;
            console.log("received person");

            this.loadSex(response.data._links.sexCode.href);
          })
          .catch(error => {
            console.log(error)
          })
          .finally(() => this.loading = false);
    },
    async loadSex(uri) {
      await axios.get(uri)
          .then(response => {
            this.person.sex = response.data.description;
            console.log("received sex");
          })
          .catch(error => {
            console.log(error)
          })
          .finally(() => this.loading = false);
    },
  },
  computed: {
    fullName: function() {
      return this.person.firstName + (this.person.middleName === '' ? ' ' : ' ' + this.person.middleName + ', ') + this.person.lastName;
    }
  },
  mounted() {
    this.loadPerson();
  },
}
</script>

<style></style>