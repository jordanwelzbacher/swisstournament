<script>
  import { MDBDatatable } from "mdb-vue-ui-kit";

  export default {
    components: {
      MDBDatatable
    },
    setup() {
      const dataset2 = {
        columns: [
          { label: "Name", field: "name" },
          { label: "Position", field: "position", sort: false },
          { label: "Office", field: "office", sort: false },
          { label: "Age", field: "age", sort: false },
          { label: "Start date", field: "date" },
          { label: "Salary", field: "salary", sort: false }
        ],
        rows: [
          {
            name: "Tiger Nixon",
            position: "System Architect",
            office: "Edinburgh",
            age: 61,
            date: "2011/04/25",
            salary: "$320,800"
          },
          {
            name: "Garrett Winters",
            position: "Accountant",
            office: "Tokyo",
            age: 63,
            date: "2011/07/25",
            salary: "$170,750"
          },
          {
            name: "Ashton Cox",
            position: "Junior Technical Author",
            office: "San Francisco",
            age: 66,
            date: "2009/01/12",
            salary: "$86,000"
          },
          {
            name: "Cedric Kelly",
            position: "Senior Javascript Developer",
            office: "Edinburgh",
            age: 22,
            date: "2012/03/29",
            salary: "$433,060"
          },
          {
            name: "Airi Satou",
            position: "Accountant",
            office: "Tokyo",
            age: 33,
            date: "2008/11/28",
            salary: "$162,700"
          },
          {
            name: "Brielle Williamson",
            position: "Integration Specialist",
            office: "New York",
            age: 61,
            date: "2012/12/02",
            salary: "$372,000"
          },
          {
            name: "Herrod Chandler",
            position: "Sales Assistant",
            office: "San Francisco",
            age: 59,
            date: "2012/08/06",
            salary: "$137,500"
          },
          {
            name: "Rhona Davidson",
            position: "Integration Specialist",
            office: "Tokyo",
            age: 55,
            date: "2010/10/14",
            salary: "$327,900"
          },
          {
            name: "Colleen Hurst",
            position: "Javascript Developer",
            office: "San Francisco",
            age: 39,
            date: "2009/09/15",
            salary: "$205,500"
          },
          {
            name: "Sonya Frost",
            position: "Software Engineer",
            office: "Edinburgh",
            age: 23,
            date: "2008/12/13",
            salary: "$103,600"
          },
          {
            name: "Jena Gaines",
            position: "Office Manager",
            office: "London",
            age: 30,
            date: "2008/12/19",
            salary: "$90,560"
          },
          {
            name: "Quinn Flynn",
            position: "Support Lead",
            office: "Edinburgh",
            age: 22,
            date: "2013/03/03",
            salary: "$342,000"
          },
          {
            name: "Charde Marshall",
            position: "Regional Director",
            office: "San Francisco",
            age: 36,
            date: "2008/10/16",
            salary: "$470,600"
          },
          {
            name: "Haley Kennedy",
            position: "Senior Marketing Designer",
            office: "London",
            age: 43,
            date: "2012/12/18",
            salary: "$313,500"
          }
        ]
      };

      return {
        dataset2
      };
    }
  };
</script>