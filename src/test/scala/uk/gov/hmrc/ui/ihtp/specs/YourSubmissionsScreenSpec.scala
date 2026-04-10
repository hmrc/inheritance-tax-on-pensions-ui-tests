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

class YourSubmissionsScreenSpec extends BaseSpec {

  Feature("Your Submissions page") {

    Scenario("1. Verify user can access the Your Submissions page") {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsOrgUserWithPsaEnrolment()

      When("the user navigates to the Your Submissions page")
      AuthLoginPage.navigateTo(YourSubmissionsPage.pageUrl)

      Then("the Your Submissions page URL should be correct")
      YourSubmissionsPage.verifyPageUrl() shouldBe true

      And("the Your Submissions page title should be correct")
      YourSubmissionsPage.verifyPageTitle() shouldBe true

      And("the page heading should be displayed")
      YourSubmissionsPage.verifyPageHeading() shouldBe true

      And("the GOV.UK footer links should be present")
      YourSubmissionsPage.verifyFooterLinksArePresent() shouldBe true

      And("the Sign out link should be displayed")
      AuthLoginPage.verifySignOutLinkText() shouldBe true
    }

    Scenario("2. User without enrolment cannot access the Your Submissions page") {
      Given("the user is logged in as an organisation user without enrolment")
      AuthLoginPage.loginAsOrgUserWithoutEnrolment()

      When("the user tries to navigate to the Your Submissions page")
      AuthLoginPage.navigateTo(YourSubmissionsPage.mpsPageUrl)

      Then("the user should see the registration page for pension scheme administrators or practitioners")
      YourSubmissionsPage.verifyRegistrationReminderPage() shouldBe true

      And("the page URL should not be the Your Submissions page URL")
      YourSubmissionsPage.verifyPageUrl() shouldBe false
    }
  }
}
