import teamYaml from "./team-openapi.yaml";
import testYaml from "./test-openapi.yaml";
import YAML from "json2yaml";

let apiSpec = "";

let teamSpec = YAML.stringify(teamYaml);
apiSpec += teamSpec;

let testSpec = YAML.stringify(testYaml);
apiSpec += testSpec;


export default apiSpec;