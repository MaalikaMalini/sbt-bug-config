/*
 * Copyright (C) 2019  Maalikamalini Chandrasekar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import cats.effect._
import com.typesafe.config.ConfigFactory
import config.DatabaseConfig
import pureconfig._

object program extends IOApp {
  @SuppressWarnings(Array("org.wartremover.warts.Any"))
  def run(args: List[String]): IO[ExitCode] = {
    val pgm = for {
      cfg <- IO(ConfigFactory.load())
      dbc <- IO(ConfigSource.fromConfig(cfg).at(namespace = "database").loadOrThrow[DatabaseConfig])
      _   <- IO(println(dbc))
    } yield ExitCode.Success
    pgm
  }

}
