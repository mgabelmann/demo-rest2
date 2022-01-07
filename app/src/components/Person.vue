<template>
  <Card style="width:50rem;">
    <template #title>
      {{fullName}}
    </template>
    <template #content>
      <div class="grid">
        <div class="col-6">
          <span class="p-float-label">
            <InputText id="firstname" type="text" v-model="firstName"/>
            <label for="firstname">First Name</label>
          </span>
        </div>
        <div class="col-6">
          <span class="p-float-label">
            <InputText id="lastname" type="text" v-model="lastName"/>
            <label for="lastname">Last Name</label>
          </span>
        </div>
        <div class="col-6">
          <span class="p-float-label">
            <InputText id="middlename" type="text" v-model="middleName"/>
            <label for="middlename">Middle Name</label>
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
    Card, InputText
  },
  data() {
    return {
      loading: true,

      personId: 'id',
      firstName: 'Jane',
      lastName: 'Doe',
      middleName: '',
      sex: 'M',
    }
  },
  methods() {

  },
  computed: {
    fullName: function() {
      return this.firstName + (this.middleName === '' ? ' ' : ' ' + this.middleName + ', ') + this.lastName;
    }
  },
  mounted() {
    axios.get('http://localhost:8080/persons/1')
        .then(response => {
          this.personId = response.data.personId;
          this.firstName = response.data.firstName;
          this.lastName = response.data.lastName;
          this.middleName = response.data.middleName == null ? '' : response.data.middleName;
        })
        .catch(error => {
          console.log(error)
        })
        .finally(() => this.loading = false)
  }
}
</script>

<style>

</style>