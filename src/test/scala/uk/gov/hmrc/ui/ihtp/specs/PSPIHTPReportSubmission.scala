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

class PSPIHTPReportSubmission extends BaseSpec {

  Feature("PSP IHTP Report Submission") {

    Scenario("1. PSP User Can Submit IHTP Application") {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPspEnrolment()

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
      EnterTheInheritanceTaxReferenceNumberPage.enterReferenceNumber("F123456/25B")

      When("user click On save and Continue navigates to the Check and submit the report page")
      EnterTheInheritanceTaxReferenceNumberPage.navigateTo(CheckYourAnswersPage.pageUrl)
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

      And("User should be able to Navigates to Psp-Declaration Page")
      CheckYourAnswersPage.navigateTo(PSPDeclarationPage.pageUrl)
      PSPDeclarationPage.verifyPageUrl()     shouldBe true
      PSPDeclarationPage.verifyPageTitle()   shouldBe true
      PSPDeclarationPage.verifyPageHeading() shouldBe true

      And(" User should be enter Administrator's id on Psp-Declaration Page")
      PSPDeclarationPage.enterAdministratorId("A2100005")

      And(" click on Agree and Submit Button on Psp-Declaration Page")
      PSPDeclarationPage.AgreeAndSubmitButton()

      And("User should be able to Navigates to Submission Page")
      PSPDeclarationPage.navigateTo(ReportSubmittedPage.pageUrl)
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
