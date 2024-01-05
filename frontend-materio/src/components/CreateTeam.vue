<template>

    <v-card outlined>
        <v-card-title>
            CreateTeam
        </v-card-title>

        <v-card-text>
            <String label="TeamName" v-model="value.teamName" :editMode="editMode"/>
            <NameList offline label="TeamMembers" v-model="value.teamMembers" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createTeam"
            >
                CreateTeam
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
import String from './primitives/String.vue'

export default {
    name: 'CreateTeamCommand',
    components:{
        String,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.teamName = '';
        this.value.teamMembers = [];
    },
    watch: {
    },
    methods: {
        createTeam() {
            this.$emit('createTeam', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

