package innerspaceAdmPnl.api.schemavalidation.asserts;

import innerspaceAdmPnl.api.common.ResponseValidation;
import org.testng.asserts.SoftAssert;

//Asserts used to validate json schema for Integration tests
public class ValidationSchemaAssert {

    private SoftAssert softAssert;

    public ValidationSchemaAssert() {
        this.softAssert = new SoftAssert();
    }

    public void assertResponseStructure(ResponseValidation responseValidation) {
        // Check and report on unexpected fields in the response
        if (!responseValidation.getUnknownFields().isEmpty()) {
            for (int i = 0; i < responseValidation.getUnknownFields().size(); i++) {
                this.softAssert.fail("Unexpected field detected: " + responseValidation.getUnknownFields().get(i));
            }
        }
        // Check and report on required fields that are missing in the response
        if (!responseValidation.getClassRequiredFields().isEmpty()) {
            for (int i = 0; i < responseValidation.getClassRequiredFields().size(); i++) {
                this.softAssert.fail("Missing required field: " + responseValidation.getClassRequiredFields().get(i) +
                        ". This field is essential for correct response structure.");
            }
        }
        // Check and report on required fields present in the response but are empty
        if (!responseValidation.getRequiredFieldMissingValue().isEmpty()) {
            for (int i = 0; i < responseValidation.getRequiredFieldMissingValue().size(); i++) {
                this.softAssert.fail("Required field without value: " + responseValidation.getRequiredFieldMissingValue().get(i) +
                        ". The field exists but has no value, which is required.");
            }
        }
        // Check and report on fields that have incorrect data types according to the schema
        if (!responseValidation.getWrongTypeFields().isEmpty()) {
            for (int i = 0; i < responseValidation.getWrongTypeFields().size(); i++) {
                this.softAssert.fail("Field with incorrect data type: " + responseValidation.getWrongTypeFields().get(i) +
                        ". The data type of this field does not match the expected schema definition.");
            }
        }
        this.softAssert.assertAll();
    }
}
