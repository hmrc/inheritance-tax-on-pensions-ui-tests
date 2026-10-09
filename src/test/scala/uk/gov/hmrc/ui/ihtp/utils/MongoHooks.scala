/*
 * Copyright 2026 HM Revenue & Customs
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

package uk.gov.hmrc.ui.ihtp.utils

import scala.sys.process.*

object MongoHooks {

  private val mongoUri = "mongodb://localhost:27017"

  private val script: String =
    """
      |const backend = db.getSiblingDB("inheritance-tax-on-pensions");
      |printjson(backend.getCollection("user-answers").deleteMany({}));
      |printjson(backend.getCollection("scheme-details").deleteMany({}));
      |
      |const frontend = db.getSiblingDB("inheritance-tax-on-pensions-frontend");
      |printjson(frontend.getCollection("minimal-details").deleteMany({}));
      |printjson(frontend.getCollection("scheme-details").deleteMany({}));
      |""".stripMargin

  def clearMongo(): Unit = {
//    val exitCode = Seq("mongosh", mongoUri, "--eval", script).!
    val exitCode = Seq("docker", "exec", "mongodb", "mongosh", "mongodb://localhost:27017", "--eval", script).!
    require(exitCode == 0, s"mongosh exited with code $exitCode while clearing test data")
  }

}
