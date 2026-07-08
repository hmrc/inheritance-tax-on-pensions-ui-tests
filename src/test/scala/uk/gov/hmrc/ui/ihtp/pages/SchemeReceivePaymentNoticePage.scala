package uk.gov.hmrc.ui.ihtp.pages

object SchemeReceivePaymentNoticePage extends BasePage {
  override val pageUrl: String   = s"$baseUrl/scheme-receive-payment-notice"
  override val pageTitle: String =
    "When did Mr Firstname Middlename Lastname Pension Scheme receive the payment notice? - Report inheritance tax on a pension - GOV.UK"
  val pageHeading: String        = "When did Smith Harper Pension Scheme receive the payment notice?"

  def SaveAndContinueButton(): Unit =
    clickSaveAndContinueButton()

  def dateOfReceivingPaymentNotice(day: String, month: String, year: String): Unit = {
    checkURL
    enterText("dateThePensionSchemeReceivedNoticeToPay.day", day)
    enterText("dateThePensionSchemeReceivedNoticeToPay.month", month)
    enterText("dateThePensionSchemeReceivedNoticeToPay.year", year)
  }

}
