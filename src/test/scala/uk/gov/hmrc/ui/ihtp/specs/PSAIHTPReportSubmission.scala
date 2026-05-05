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

import uk.gov.hmrc.ui.ihtp.specs.tags.AllTests
import uk.gov.hmrc.ui.ihtp.pages.*

class PSAIHTPReportSubmission extends BaseSpec {

  Feature("PSA IHTP Report Submission") {

    Scenario("1. PSA User Can Submit IHTP Application, Individual") {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPsaEnrolment()

      When("the user navigates to the What You will need page")
      AuthLoginPage.navigateTo(WhatYouWillNeedPage.pageUrl)

      Then("the What You will need page URL should be correct")
      WhatYouWillNeedPage.verifyPageUrl() shouldBe true

      And("the What You will need page title should be correct")
      WhatYouWillNeedPage.verifyPageTitle() shouldBe true

      And("the page heading should be displayed")
      WhatYouWillNeedPage.verifyPageHeading() shouldBe true

      And("User Should be able to see and Click Save and Continue Button")
      WhatYouWillNeedPage.SaveAndContinueButton()

      And("User should be able to Navigate to Enter the Inheritance Tax reference number Page ")
      WhatYouWillNeedPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.pageUrl)

      And("User is on the Enter the Inheritance Tax reference number Page")
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageUrl()     shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageTitle()   shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageHeading() shouldBe true

      And("User is able to enter Tax reference number")
      EnterTheInheritanceTaxReferenceNumberPage.enterReferenceNumber("A123456/25A")

      And("User Should be able to see and Click Save and Continue Button")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()

      // Deceased name page
      And("User should be able to Navigate to Deceased Name Page ")
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(DeceasedNamePage.pageUrl)

      And("User is on the Deceased Name Page")
      DeceasedNamePage.verifyPageUrl()     shouldBe true
      DeceasedNamePage.verifyPageTitle()   shouldBe true
      DeceasedNamePage.verifyPageHeading() shouldBe true

      And("User is able to enter Details of the Deceased")
      DeceasedNamePage.enterDeceasedDetails(
        "Mr",
        "ABC",
        "P",
        "XYZ"
      )

      And("User Should be able to see and Click Save and Continue Button")
      DeceasedNamePage.SaveAndContinueButton()

      Then("User should be able to Navigate to National Insurance Number Page")
      DeceasedNamePage.navigateTo(NationalInsuranceNumberPage.pageUrl)
      NationalInsuranceNumberPage.verifyPageUrl()   shouldBe true
      NationalInsuranceNumberPage.verifyPageTitle() shouldBe true

      And("User selects No for Does User has National Number")
      NationalInsuranceNumberPage.clickRadioButton("No")

      Then("User Enter Reason for no National Insurance Number and continue")
      NationalInsuranceNumberPage.enterReason("Test")

      Then("User should be on Enter the birth and death dates of the user")
      NationalInsuranceNumberPage.navigateTo(EnterBirthDeathPage.pageUrl)
      EnterBirthDeathPage.verifyPageUrl()   shouldBe true
      EnterBirthDeathPage.verifyPageTitle() shouldBe true

      And("User should be able to enter Date of Birth and Death Date")
      EnterBirthDeathPage.enterBirthDate("01", "01", "1990")
      EnterBirthDeathPage.enterDeathDate("11", "12", "2025")

      When("user click On save and Continue navigates to the LPR Type page")
      EnterBirthDeathPage.navigateTo(LPRTypePage.pageUrl)
      LPRTypePage.verifyPageUrl()   shouldBe true
      LPRTypePage.verifyPageTitle() shouldBe true
      // CheckYourAnswersPage.verifyPageHeading() shouldBe true

      And("User selects Individual for LPR Type")
      LPRTypePage.clickRadioButton("Individual")

      // LPR Name (individual)

      And("User should be able to Navigate to LPR Name Page")
      LPRTypePage.navigateTo(LPRNamePage.pageUrl)

      And("User is on the LPR Name Page")
      LPRNamePage.verifyPageUrl()     shouldBe true
      LPRNamePage.verifyPageTitle()   shouldBe true
      LPRNamePage.verifyPageHeading() shouldBe true

      And("User is able to enter Details of the LPR")
      LPRNamePage.enterLPRDetails(
        "Mr",
        "ABC",
        "P",
        "XYZ"
      )

      And("User Should be able to see and Click Save and Continue Button")
      LPRNamePage.SaveAndContinueButton()

      //

      When("user click On save and Continue navigates to the Check and submit the report page")
      LPRTypePage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageUrl()     shouldBe true
      CheckYourAnswersPage.verifyPageTitle()   shouldBe true
      CheckYourAnswersPage.verifyPageHeading() shouldBe true

      Then("User should be able to click on Change Link Button")
      CheckYourAnswersPage.ClickChangeLink()

      And("When User Clicks on Change Link Button it will navigates to enter the Inheritance Tax reference number Page")
      CheckYourAnswersPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.newUrl)
      EnterTheInheritanceTaxReferenceNumberPage.verifyNewUrl() shouldBe true

      When("user click On save and Continue it navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageUrl() shouldBe true

      Then("User click on Save and Continue button on the Check and submit the report page ")
      CheckYourAnswersPage.SaveAndContinueButton()

      And("User should be able to Navigates to Psa-Declaration Page")
      CheckYourAnswersPage.navigateTo(PSADeclarationPage.pageUrl)
      PSADeclarationPage.verifyPageUrl()     shouldBe true
      PSADeclarationPage.verifyPageTitle()   shouldBe true
      PSADeclarationPage.verifyPageHeading() shouldBe true

      And("User should be click on Agree and Submit Button on Psa-Declaration Page")
      PSADeclarationPage.AgreeAndSubmitButton()

      And("User should be able to Navigates to Submission Page")
      PSADeclarationPage.navigateTo(ReportSubmittedPage.pageUrl)
      ReportSubmittedPage.verifyPageUrl()     shouldBe true
      ReportSubmittedPage.verifyPageTitle()   shouldBe true
      ReportSubmittedPage.verifyPageHeading() shouldBe true

      And("the GOV.UK footer links should be present")
      ReportSubmittedPage.verifyFooterLinksArePresent() shouldBe true

      And("the Sign out link should be displayed")
      AuthLoginPage.verifySignOutLinkText() shouldBe true
    }

    Scenario("2. PSA User Can Submit IHTP Application, Organisation") {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPsaEnrolment()

      When("the user navigates to the What You will need page")
      AuthLoginPage.navigateTo(WhatYouWillNeedPage.pageUrl)

      Then("the What You will need page URL should be correct")
      WhatYouWillNeedPage.verifyPageUrl() shouldBe true

      And("the What You will need page title should be correct")
      WhatYouWillNeedPage.verifyPageTitle() shouldBe true

      And("the page heading should be displayed")
      WhatYouWillNeedPage.verifyPageHeading() shouldBe true

      And("User Should be able to see and Click Save and Continue Button")
      WhatYouWillNeedPage.SaveAndContinueButton()

      And("User should be able to Navigate to Enter the Inheritance Tax reference number Page ")
      WhatYouWillNeedPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.pageUrl)

      And("User is on the Enter the Inheritance Tax reference number Page")
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageUrl()     shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageTitle()   shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageHeading() shouldBe true

      And("User is able to enter Tax reference number")
      EnterTheInheritanceTaxReferenceNumberPage.enterReferenceNumber("A123456/25A")

      And("User Should be able to see and Click Save and Continue Button")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()

      // Deceased name page
      And("User should be able to Navigate to Deceased Name Page ")
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(DeceasedNamePage.pageUrl)

      And("User is on the Deceased Name Page")
      DeceasedNamePage.verifyPageUrl()     shouldBe true
      DeceasedNamePage.verifyPageTitle()   shouldBe true
      DeceasedNamePage.verifyPageHeading() shouldBe true

      And("User is able to enter Details of the Deceased")
      DeceasedNamePage.enterDeceasedDetails(
        "Mr",
        "ABC",
        "P",
        "XYZ"
      )

      And("User Should be able to see and Click Save and Continue Button")
      DeceasedNamePage.SaveAndContinueButton()

      Then("User should be able to Navigate to National Insurance Number Page")
      DeceasedNamePage.navigateTo(NationalInsuranceNumberPage.pageUrl)
      NationalInsuranceNumberPage.verifyPageUrl()   shouldBe true
      NationalInsuranceNumberPage.verifyPageTitle() shouldBe true

      And("User selects No for Does User has National Number")
      NationalInsuranceNumberPage.clickRadioButton("No")

      Then("User Enter Reason for no National Insurance Number and continue")
      NationalInsuranceNumberPage.enterReason("Test")

      Then("User should be on Enter the birth and death dates of the user")
      NationalInsuranceNumberPage.navigateTo(EnterBirthDeathPage.pageUrl)
      EnterBirthDeathPage.verifyPageUrl()   shouldBe true
      EnterBirthDeathPage.verifyPageTitle() shouldBe true

      And("User should be able to enter Date of Birth and Death Date")
      EnterBirthDeathPage.enterBirthDate("01", "01", "1990")
      EnterBirthDeathPage.enterDeathDate("11", "12", "2025")

      When("user click On save and Continue navigates to the LPR Type page")
      EnterBirthDeathPage.navigateTo(LPRTypePage.pageUrl)
      LPRTypePage.verifyPageUrl()   shouldBe true
      LPRTypePage.verifyPageTitle() shouldBe true
      // CheckYourAnswersPage.verifyPageHeading() shouldBe true

      And("User selects Individual for Does User has National Number")
      LPRTypePage.clickRadioButton("Organisation")

      When("user click On save and Continue navigates to the Check and submit the report page")
      LPRTypePage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageUrl()     shouldBe true
      CheckYourAnswersPage.verifyPageTitle()   shouldBe true
      CheckYourAnswersPage.verifyPageHeading() shouldBe true

      Then("User should be able to click on Change Link Button")
      CheckYourAnswersPage.ClickChangeLink()

      And("When User Clicks on Change Link Button it will navigates to enter the Inheritance Tax reference number Page")
      CheckYourAnswersPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.newUrl)
      EnterTheInheritanceTaxReferenceNumberPage.verifyNewUrl() shouldBe true

      When("user click On save and Continue it navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageUrl() shouldBe true

      Then("User click on Save and Continue button on the Check and submit the report page ")
      CheckYourAnswersPage.SaveAndContinueButton()

      And("User should be able to Navigates to Psa-Declaration Page")
      CheckYourAnswersPage.navigateTo(PSADeclarationPage.pageUrl)
      PSADeclarationPage.verifyPageUrl()     shouldBe true
      PSADeclarationPage.verifyPageTitle()   shouldBe true
      PSADeclarationPage.verifyPageHeading() shouldBe true

      And("User should be click on Agree and Submit Button on Psa-Declaration Page")
      PSADeclarationPage.AgreeAndSubmitButton()

      And("User should be able to Navigates to Submission Page")
      PSADeclarationPage.navigateTo(ReportSubmittedPage.pageUrl)
      ReportSubmittedPage.verifyPageUrl()     shouldBe true
      ReportSubmittedPage.verifyPageTitle()   shouldBe true
      ReportSubmittedPage.verifyPageHeading() shouldBe true

      And("the GOV.UK footer links should be present")
      ReportSubmittedPage.verifyFooterLinksArePresent() shouldBe true

      And("the Sign out link should be displayed")
      AuthLoginPage.verifySignOutLinkText() shouldBe true
    }

    Scenario(
      "3. PSA User able to submit IHTP Report Submission with Reference number Leading and trailing white space "
    ) {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPsaEnrolment()

      When("the user navigates to the What You will need page")
      AuthLoginPage.navigateTo(WhatYouWillNeedPage.pageUrl)

      Then("the What You will need page URL should be correct")
      WhatYouWillNeedPage.verifyPageUrl() shouldBe true

      And("the What You will need page title should be correct")
      WhatYouWillNeedPage.verifyPageTitle() shouldBe true

      And("the page heading should be displayed")
      WhatYouWillNeedPage.verifyPageHeading() shouldBe true

      And("User Should be able to see and Click Save and Continue Button")
      WhatYouWillNeedPage.SaveAndContinueButton()

      And("User should be able to Navigate to Enter the Inheritance Tax reference number Page ")
      WhatYouWillNeedPage.navigateTo(EnterTheInheritanceTaxReferenceNumberPage.pageUrl)

      And("User is on the Enter the Inheritance Tax reference number Page")
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageUrl()     shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageTitle()   shouldBe true
      EnterTheInheritanceTaxReferenceNumberPage.verifyPageHeading() shouldBe true

      And("User is able to enter Tax reference number")
      EnterTheInheritanceTaxReferenceNumberPage.enterReferenceNumber(" A123456/25A ")

      When("user click On save and Continue navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageUrl()     shouldBe true
      CheckYourAnswersPage.verifyPageTitle()   shouldBe true
      CheckYourAnswersPage.verifyPageHeading() shouldBe true

      When("user click On save and Continue it navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.SaveAndContinueButton()
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
      CheckYourAnswersPage.verifyPageUrl() shouldBe true

      Then("User click on Save and Continue button on the Check and submit the report page ")
      CheckYourAnswersPage.SaveAndContinueButton()

      And("User should be able to Navigates to Psa-Declaration Page")
      CheckYourAnswersPage.navigateTo(PSADeclarationPage.pageUrl)
      PSADeclarationPage.verifyPageUrl()     shouldBe true
      PSADeclarationPage.verifyPageTitle()   shouldBe true
      PSADeclarationPage.verifyPageHeading() shouldBe true

      And("User should be click on Agree and Submit Button on Psa-Declaration Page")
      PSADeclarationPage.AgreeAndSubmitButton()

      And("User should be able to Navigates to Submission Page")
      PSADeclarationPage.navigateTo(ReportSubmittedPage.pageUrl)
      ReportSubmittedPage.verifyPageUrl()     shouldBe true
      ReportSubmittedPage.verifyPageTitle()   shouldBe true
      ReportSubmittedPage.verifyPageHeading() shouldBe true

      And("the GOV.UK footer links should be present")
      ReportSubmittedPage.verifyFooterLinksArePresent() shouldBe true

      And("the Sign out link should be displayed")
      AuthLoginPage.verifySignOutLinkText() shouldBe true

    }
  }

}
