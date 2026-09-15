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

class PSAIHTPPaidReport extends BaseSpec {

  Feature("Paid reports page for a PSA") {

    Scenario("1. PSA User Can go to the View Paid Reports page from the Overview Page") {

      Given("the user is logged in as an organisation user")
      AuthLoginPage.loginAsPsaOrgUserForSubmission()

      And("User is navigated to the Report Inheritance Tax on a pension (Overview) Page")
      AuthLoginPage.navigateTo(OverviewPage.pageUrl)
      OverviewPage.verifyPageDetails() shouldBe true
      OverviewPage.verifyPageHeading() shouldBe true

      Then("User clicks on View paid reports link and navigates to the View Paid Reports Page")
      OverviewPage.clickViewPaidReportsLink()
      OverviewPage.navigateTo(PaidReportsPage.pageUrl)
      PaidReportsPage.verifyPageDetails() shouldBe true
      PaidReportsPage.verifyPageHeading() shouldBe true

      Then(
        "User clicks on the Return to active reports link and navigates back to the Report Inheritance Tax on a pension (Overview) Page"
      )
      PaidReportsPage.clickReturnToActiveReportsLink()
      OverviewPage.verifyPageDetails() shouldBe true
      OverviewPage.verifyPageHeading() shouldBe true

    }
  }
}
