/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.ihtp.specs

import uk.gov.hmrc.ui.ihtp.pages.*

class PSAIHTPReportSubmission extends BaseSpec {

  Feature("PSA IHTP Report Submission") {

    Scenario(
      "1. PSA User Can Submit IHTP Application, Individual, Yes for Payment notice submission, Yes for beneficiaries known"
    ) {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPsaEnrolment()

      When("the user navigates to the What You will need page")
      AuthLoginPage.navigateTo(WhatYouWillNeedPage.pageUrl)

      And("the What You will need page details are correct")
      WhatYouWillNeedPage.verifyPageDetails() shouldBe true

      And("the page heading should be displayed")
      WhatYouWillNeedPage.verifyPageHeading() shouldBe true

      And("User clicks the Continue Button on the What you will need Page")
      WhatYouWillNeedPage.SaveAndContinueButton()

//      And("User navigates to Enter the Inheritance Tax reference number Page")
//      WhatYouWillNeedPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.pageUrl)

      Then("the user is navigated to the Enter the Inheritance Tax reference number Page")
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageDetails() shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageHeading() shouldBe true

      And("User enters the Tax reference number and continues to next Page")
      EnterTheInheritanceTaxReferenceNumberPage.enterReferenceNumber("A123456/25A")

      // Deceased name page
//      And("User should be able to Navigate to Deceased Name Page")
//      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(DeceasedNamePage.pageUrl)

      Then("User is navigated to the Deceased Name Page")
      DeceasedNamePage.verifyPageDetails() shouldBe true
      DeceasedNamePage.verifyPageHeading() shouldBe true

      And("User is able to enter Details of the Deceased and continues to next Page")
      DeceasedNamePage.enterDeceasedDetails(
        "Mr",
        "TestFirstname",
        "TestMiddleName",
        "TestLastName"
      )

      Then("User is navigated to the National Insurance Number Page")
      DeceasedNamePage.navigateTo(NationalInsuranceNumberPage.pageUrl)
      NationalInsuranceNumberPage.verifyPageDetails() shouldBe true

      And("User selects No for Does User has National Number?")
      NationalInsuranceNumberPage.clickRadioButton("No")

      Then("User Enters Reason for no National Insurance Number and continues to next Page")
      NationalInsuranceNumberPage.enterReason("Test")

      Then("User is navigated to the Enter the birth and death dates of the user Page")
//      NationalInsuranceNumberPage.navigateTo(EnterBirthDeathPage.pageUrl)
      EnterBirthDeathPage.verifyPageDetails() shouldBe true

      And("User enters Date of Birth and Death Date")
      EnterBirthDeathPage.enterBirthDate("01", "01", "1990")
      EnterBirthDeathPage.enterDeathDate("11", "12", "2025")

      Then("the user clicks on Save and continue button on Date of Birth and Death Date Page")
      EnterBirthDeathPage.SaveAndContinueButton()

      Then(
        "User is navigated to the Is the personal representative (PR) an individual or a member of an organisation? Page"
      )
      PRTypePage.verifyPageDetails() shouldBe true

      And("User selects Individual for PR Type and then continues to next Page")
      PRTypePage.clickRadioButton("Individual")
      PRTypePage.clickSaveAndContinueButton()

//      And("User is navigated to PR Name Page")
//      PRTypePage.navigateTo(PRNamePage.pageUrl)

      Then("User is navigated to the PR Name Page")
      PRNamePage.verifyPageDetails() shouldBe true
      PRNamePage.verifyPageHeading() shouldBe true

      And("User is able to enter Details of the PR and continues to next Page")
      PRNamePage.enterPRDetails(
        "Mr",
        "ABC",
        "P",
        "XYZ"
      )
      PRNamePage.SaveAndContinueButton()

      Then("User is navigated to the Select Country Page")
      CountryPickerPage.verifyPage()
      CountryPickerPage.enterCountry("United Kingdom")
      CountryPickerPage.SaveAndContinueButton()

      Then("User is navigated to Look Up Address Page")
      LookUpPostcodePage.verifyPage()
      LookUpPostcodePage.enterPostcode("ZZ1 1ZZ")
      LookUpPostcodePage.SaveAndContinueButton()

      And("User is navigated to Choose Address Page")
      ChooseAddressPage.verifyPage()
      ChooseAddressPage.clickRadioButton("4")
      ChooseAddressPage.clickSaveAndContinueButton()

      Then("User is navigated to Review and confirm Page")
      ReviewAndConfirmPage.verifyPageHeading() shouldBe true
      ReviewAndConfirmPage.verifyPage()
      ReviewAndConfirmPage.confirmAddressButton()

      Then("User is navigated to Did a a submit the payment notice? page")
      SubmitPaymentNoticePage.verifyPageDetails() shouldBe true

      And("User Clicks on Yes Radio button and click on continue button")
      SubmitPaymentNoticePage.clickRadioButton("Yes")

      Then("User is navigated to When did the scheme receive the payment notice? Page")
      SchemeReceivePaymentNoticePage.verifyPageDetails()

      And("User should be able to enter date of receiving payment notice")
      SchemeReceivePaymentNoticePage.dateOfReceivingPaymentNotice("01", "01", "2026")

      When("User clicks on Save and continue button and it navigates to the next page")
      SchemeReceivePaymentNoticePage.clickSaveAndContinueButton()

      Then("User is navigated to the Are the beneficiaries known page")
      AreBeneficiariesKnownPage.navigateTo(AreBeneficiariesKnownPage.pageUrl)
      AreBeneficiariesKnownPage.verifyPageDetails() shouldBe true

      And("User Clicks on Yes Radio button and clicks on Save and continue button")
      AreBeneficiariesKnownPage.clickRadioButton("Yes")

      Then("User will be on CYA page")
      CheckYourAnswersPage.verifyPageDetails() shouldBe true
      CheckYourAnswersPage.verifyPageHeading() shouldBe true

      Then("User should be able to click on Change Link Button")
      CheckYourAnswersPage.ClickChangeLink()

      And("When User Clicks on Change Link Button it will navigates to enter the Inheritance Tax reference number Page")
      CheckYourAnswersPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.newUrl)
      EnterTheInheritanceTaxReferenceNumberPage.verifyNewUrl() shouldBe true

      When("user clicks on Save and continue it navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageDetails()

      Then("User clicks on Save and Continue button on the Check and submit the report page ")
      CheckYourAnswersPage.SaveAndContinueButton()

      And("User should be able to Navigates to Psa-Declaration Page")
      CheckYourAnswersPage.navigateTo(PSADeclarationPage.pageUrl)
      PSADeclarationPage.verifyPageDetails() shouldBe true
      PSADeclarationPage.verifyPageHeading() shouldBe true

      And("User should be click on Agree and Submit Button on Psa-Declaration Page")
      PSADeclarationPage.AgreeAndSubmitButton()

      And("User should be able to Navigates to Submission Page")
      PSADeclarationPage.navigateTo(ReportSubmittedPage.pageUrl)
      ReportSubmittedPage.verifyPageDetails() shouldBe true
      ReportSubmittedPage.verifyPageHeading() shouldBe true

      And("the GOV.UK footer links should be present")
      ReportSubmittedPage.verifyFooterLinksArePresent() shouldBe true

      And("the Sign out link should be displayed")
      AuthLoginPage.verifySignOutLinkText() shouldBe true
    }

    Scenario(
      "2. PSA User Can Submit IHTP Application, Organisation, and Yes for Payment Notice submission, Yes for beneficiaries known"
    ) {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPsaEnrolment()

      When("the user navigates to the What You will need page")
      AuthLoginPage.navigateTo(WhatYouWillNeedPage.pageUrl)

      And("the What You will need page details are correct")
      WhatYouWillNeedPage.verifyPageDetails() shouldBe true
      WhatYouWillNeedPage.verifyPageHeading() shouldBe true

      When("User clicks on Continue button and it navigates to the next page")
      WhatYouWillNeedPage.clickSaveAndContinueButton()

//      And("User should be able to Navigate to Enter the Inheritance Tax reference number Page ")
//      WhatYouWillNeedPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.pageUrl)
//      EnterTheInheritanceTaxReferenceNumberPage.verifyPageDetails() shouldBe true
//      EnterTheInheritanceTaxReferenceNumberPage.verifyPageHeading() shouldBe true

      Then("the user is navigated to the Enter the Inheritance Tax reference number Page")
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageDetails() shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageHeading() shouldBe true

      And("User enters the Tax reference number and continues to next Page")
      EnterTheInheritanceTaxReferenceNumberPage.enterReferenceNumber("A123456/25A")

      // Deceased name page
      //      And("User should be able to Navigate to Deceased Name Page")
      //      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(DeceasedNamePage.pageUrl)

      Then("User is navigated to the Deceased Name Page")
      DeceasedNamePage.verifyPageDetails() shouldBe true
      DeceasedNamePage.verifyPageHeading() shouldBe true

      And("User is able to enter Details of the Deceased")
      DeceasedNamePage.enterDeceasedDetails(
        "Mr",
        "TestFirstname",
        "TestMiddleName",
        "TestLastName"
      )

      Then("User is navigated to the National Insurance Number Page")
      DeceasedNamePage.navigateTo(NationalInsuranceNumberPage.pageUrl)
      NationalInsuranceNumberPage.verifyPageDetails() shouldBe true

      And("User selects No for Does User has National Number?")
      NationalInsuranceNumberPage.clickRadioButton("No")

      Then("User Enters Reason for no National Insurance Number and continues to next Page")
      NationalInsuranceNumberPage.enterReason("Test")

      Then("User is navigated to the Enter the birth and death dates of the user Page")
      //      NationalInsuranceNumberPage.navigateTo(EnterBirthDeathPage.pageUrl)
      EnterBirthDeathPage.verifyPageDetails() shouldBe true

      And("User enters Date of Birth and Death Date")
      EnterBirthDeathPage.enterBirthDate("01", "01", "1990")
      EnterBirthDeathPage.enterDeathDate("11", "12", "2025")

      Then("the user clicks on Save and continue button on Date of Birth and Death Date Page")
      EnterBirthDeathPage.SaveAndContinueButton()

      Then(
        "User is navigated to the Is the personal representative (PR) an individual or a member of an organisation? Page"
      )
      PRTypePage.verifyPageDetails() shouldBe true

      And("User selects Organisation for PR Type and continues to next Page")
      PRTypePage.clickRadioButton("Organisation")
      PRTypePage.clickSaveAndContinueButton()

      Then("User is navigated to the Enter the name of the organisation Page")
      NameOfTheOrganisationPage.verifyPageDetails() shouldBe true
      NameOfTheOrganisationPage.verifyPageHeading() shouldBe true

      And("User is able to enter Organisation name and continues to next Page")
      NameOfTheOrganisationPage.enterOrganisationName("TestOrganisation")

      Then("User is navigated to the Enter Name of the PR Organisation name Page")
      OrganisationRepresentativeNamePage.verifyPageDetails() shouldBe true

      And("User should able to enter PR details and continues to next Page")
      OrganisationRepresentativeNamePage.enterOrgRepresentativeDetails(
        "Mr",
        "John",
        "S",
        "Smith"
      )
      OrganisationRepresentativeNamePage.clickSaveAndContinueButton()

      Then("User is navigated to Did a a submit the payment notice? page")
      SubmitPaymentNoticePage.verifyPageDetails() shouldBe true

      And("User Clicks on Yes Radio button and click on continue button")
      SubmitPaymentNoticePage.clickRadioButton("Yes")

      Then("User is navigated to When did the scheme receive the payment notice? Page")
      SchemeReceivePaymentNoticePage.verifyPageDetails()

      And("User should be able to enter date of receiving payment notice")
      SchemeReceivePaymentNoticePage.dateOfReceivingPaymentNotice("01", "01", "2026")

      When("User clicks on Save and continue button and it navigates to the next page")
      SchemeReceivePaymentNoticePage.clickSaveAndContinueButton()

      Then("User is navigated to the Are the beneficiaries known page")
      AreBeneficiariesKnownPage.navigateTo(AreBeneficiariesKnownPage.pageUrl)
      AreBeneficiariesKnownPage.verifyPageDetails() shouldBe true

      And("User Clicks on Yes Radio button and clicks on Save and continue button")
      AreBeneficiariesKnownPage.clickRadioButton("Yes")

      Then("User will be on CYA page")
      CheckYourAnswersPage.verifyPageDetails() shouldBe true
      CheckYourAnswersPage.verifyPageHeading() shouldBe true

      Then("User should be able to click on Change Link Button")
      CheckYourAnswersPage.ClickChangeLink()

      And("When User Clicks on Change Link Button it will navigates to enter the Inheritance Tax reference number Page")
      CheckYourAnswersPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.newUrl)
      EnterTheInheritanceTaxReferenceNumberPage.verifyNewUrl() shouldBe true

      Then("user click On save and Continue it navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageDetails()

      And("User click on Save and Continue button on the Check and submit the report page ")
      CheckYourAnswersPage.SaveAndContinueButton()

      Then("User should be able to Navigates to Psa-Declaration Page")
      CheckYourAnswersPage.navigateTo(PSADeclarationPage.pageUrl)
      PSADeclarationPage.verifyPageDetails() shouldBe true
      PSADeclarationPage.verifyPageHeading() shouldBe true

      And("User should be click on Agree and Submit Button on Psa-Declaration Page")
      PSADeclarationPage.AgreeAndSubmitButton()

      Then("User should be able to Navigates to Submission Page")
      PSADeclarationPage.navigateTo(ReportSubmittedPage.pageUrl)
      ReportSubmittedPage.verifyPageDetails() shouldBe true
      ReportSubmittedPage.verifyPageHeading() shouldBe true

      And("the GOV.UK footer links should be present")
      ReportSubmittedPage.verifyFooterLinksArePresent() shouldBe true

      Then("the Sign out link should be displayed")
      AuthLoginPage.verifySignOutLinkText() shouldBe true
    }

    Scenario(
      "3. PSA User able to submit IHTP Report Submission with Reference number Leading and trailing white space "
    ) {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPsaEnrolment()

      When("the user navigates to the What You will need page")
      AuthLoginPage.navigateTo(WhatYouWillNeedPage.pageUrl)

      Then("the What You will need page details should be correct")
      WhatYouWillNeedPage.verifyPageDetails() shouldBe true

      And("the page heading should be displayed")
      WhatYouWillNeedPage.verifyPageHeading() shouldBe true

      And("User Should be able to see and Click Save and Continue Button")
      WhatYouWillNeedPage.SaveAndContinueButton()

      And("User should be able to Navigate to Enter the Inheritance Tax reference number Page")
      WhatYouWillNeedPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.pageUrl)

      And("User is on the Enter the Inheritance Tax reference number Page")
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageDetails() shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageHeading() shouldBe true

      And("User is able to enter Tax reference number")
      EnterTheInheritanceTaxReferenceNumberPage.enterReferenceNumber(" A123456/25A ")

      When("user click On save and Continue navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageDetails() shouldBe true
      CheckYourAnswersPage.verifyPageHeading() shouldBe true

      When("user click On save and Continue it navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageDetails()

      Then("User click on Save and Continue button on the Check and submit the report page ")
      CheckYourAnswersPage.SaveAndContinueButton()

      And("User should be able to Navigates to Psa-Declaration Page")
      CheckYourAnswersPage.navigateTo(PSADeclarationPage.pageUrl)
      PSADeclarationPage.verifyPageDetails() shouldBe true
      PSADeclarationPage.verifyPageHeading() shouldBe true

      And("User should be click on Agree and Submit Button on Psa-Declaration Page")
      PSADeclarationPage.AgreeAndSubmitButton()

      And("User should be able to Navigates to Submission Page")
      PSADeclarationPage.navigateTo(ReportSubmittedPage.pageUrl)
      ReportSubmittedPage.verifyPageDetails() shouldBe true
      ReportSubmittedPage.verifyPageHeading() shouldBe true

      And("the GOV.UK footer links should be present")
      ReportSubmittedPage.verifyFooterLinksArePresent() shouldBe true

      And("the Sign out link should be displayed")
      AuthLoginPage.verifySignOutLinkText() shouldBe true

    }

    Scenario(
      "4. PSA User Can Submit IHTP Application, Individual and Yes NI, and No for Payment Notice submission, Yes for beneficiaries known"
    ) {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPsaEnrolment()

      When("the user navigates to the What You will need page")
      AuthLoginPage.navigateTo(WhatYouWillNeedPage.pageUrl)

      And("the What You will need page details are correct")
      WhatYouWillNeedPage.verifyPageDetails() shouldBe true

      And("the page heading should be displayed")
      WhatYouWillNeedPage.verifyPageHeading() shouldBe true

      And("User clicks the Continue Button on the What you will need Page")
      WhatYouWillNeedPage.SaveAndContinueButton()

      Then("the user is navigated to the Enter the Inheritance Tax reference number Page")
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageDetails() shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageHeading() shouldBe true

      And("User is able to enter Tax reference number")
      EnterTheInheritanceTaxReferenceNumberPage.enterReferenceNumber("A123456/25A")

      Then("User is navigated to the Deceased Name Page")
      DeceasedNamePage.verifyPageDetails() shouldBe true
      DeceasedNamePage.verifyPageHeading() shouldBe true

      And("User is able to enter Details of the Deceased and continues to next Page")
      DeceasedNamePage.enterDeceasedDetails(
        "Mr",
        "Firstname",
        "Middlename",
        "Lastname"
      )

      Then("User is navigated to the National Insurance Number Page")
      DeceasedNamePage.navigateTo(NationalInsuranceNumberPage.pageUrl)
      NationalInsuranceNumberPage.verifyPageDetails() shouldBe true

      And("User selects No for Does User has National Number")
      NationalInsuranceNumberPage.clickRadioButton("Yes")

      Then("User enters reason for no National Insurance Number and continues to next Page")
      NationalInsuranceNumberPage.enterNINO("ST533331B")

      Then("User is navigated to the Enter the birth and death dates of the user Page")
//      NationalInsuranceNumberPage.navigateTo(EnterBirthDeathPage.pageUrl)
      EnterBirthDeathPage.verifyPageDetails() shouldBe true

      And("User enters Date of Birth and Death Date")
      EnterBirthDeathPage.enterBirthDate("01", "01", "1990")
      EnterBirthDeathPage.enterDeathDate("11", "12", "2025")

      Then("the user clicks on Save and continue button on Date of Birth and Death Date Page")
      EnterBirthDeathPage.SaveAndContinueButton()

      Then(
        "User is navigated to the Is the personal representative (PR) an individual or a member of an organisation? Page"
      )
      PRTypePage.verifyPageDetails() shouldBe true

      And("User selects Individual for PR Type and then continues to next Page")
      PRTypePage.clickRadioButton("Individual")
      PRTypePage.clickSaveAndContinueButton()

      Then("User is navigated to the PR Name Page")
      PRNamePage.verifyPageDetails() shouldBe true
      PRNamePage.verifyPageHeading() shouldBe true

      And("User is able to enter Details of the PR and continues to next Page")
      PRNamePage.enterPRDetails(
        "Mr",
        "ABC",
        "P",
        "XYZ"
      )
      PRNamePage.SaveAndContinueButton()

      Then("User is navigated to the Select Country Page")
      CountryPickerPage.verifyPage()
      CountryPickerPage.enterCountry("United Kingdom")
      CountryPickerPage.SaveAndContinueButton()

      Then("User is navigated to Look Up Address Page")
      LookUpPostcodePage.verifyPage()
      LookUpPostcodePage.enterPostcode("ZZ1 1ZZ")
      LookUpPostcodePage.SaveAndContinueButton()

      And("User is navigated to Choose Address Page")
      ChooseAddressPage.verifyPage()
      ChooseAddressPage.clickRadioButton("4")
      ChooseAddressPage.clickSaveAndContinueButton()

      Then("User is navigated to Review and confirm Page")
      ReviewAndConfirmPage.verifyPageHeading() shouldBe true
      ReviewAndConfirmPage.verifyPage()
      ReviewAndConfirmPage.confirmAddressButton()

      Then("User is navigated to Did a a submit the payment notice? page")
      SubmitPaymentNoticePage.verifyPageDetails() shouldBe true

      And("User Clicks on Yes Radio button and click on continue button")
      SubmitPaymentNoticePage.clickRadioButton("No")

      Then("User is navigated to When did the scheme receive the payment notice? Page")
      SchemeReceivePaymentNoticePage.verifyPageDetails()

      And("User should be able to enter date of receiving payment notice")
      SchemeReceivePaymentNoticePage.dateOfReceivingPaymentNotice("01", "01", "2026")

      When("User clicks on Save and continue button and it navigates to the next page")
      SchemeReceivePaymentNoticePage.clickSaveAndContinueButton()

      Then("User is navigated to the Are the beneficiaries known page")
      AreBeneficiariesKnownPage.navigateTo(AreBeneficiariesKnownPage.pageUrl)
      AreBeneficiariesKnownPage.verifyPageDetails() shouldBe true

      And("User Clicks on No Radio button and clicks on Save and continue button")
      AreBeneficiariesKnownPage.clickRadioButton("No")

      Then("User will be on CYA page")
      CheckYourAnswersPage.verifyPageDetails() shouldBe true
      CheckYourAnswersPage.verifyPageHeading() shouldBe true

      Then("User should be able to click on Change Link Button")
      CheckYourAnswersPage.ClickChangeLink()

      And("When User Clicks on Change Link Button it will navigates to enter the Inheritance Tax reference number Page")
      CheckYourAnswersPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.newUrl)
      EnterTheInheritanceTaxReferenceNumberPage.verifyNewUrl() shouldBe true

      When("user clicks on Save and continue it navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageDetails()

      Then("User clicks on Save and Continue button on the Check and submit the report page")
      CheckYourAnswersPage.SaveAndContinueButton()

      And("User should be able to Navigates to Psa-Declaration Page")
      CheckYourAnswersPage.navigateTo(PSADeclarationPage.pageUrl)
      PSADeclarationPage.verifyPageDetails() shouldBe true
      PSADeclarationPage.verifyPageHeading() shouldBe true

      And("User should be click on Agree and Submit Button on Psa-Declaration Page")
      PSADeclarationPage.AgreeAndSubmitButton()

      And("User should be able to Navigates to Submission Page")
      PSADeclarationPage.navigateTo(ReportSubmittedPage.pageUrl)
      ReportSubmittedPage.verifyPageDetails() shouldBe true
      ReportSubmittedPage.verifyPageHeading() shouldBe true

      And("the GOV.UK footer links should be present")
      ReportSubmittedPage.verifyFooterLinksArePresent() shouldBe true

      And("the Sign out link should be displayed")
      AuthLoginPage.verifySignOutLinkText() shouldBe true
    }

  }

}
