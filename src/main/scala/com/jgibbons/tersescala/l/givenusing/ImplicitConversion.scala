package com.jgibbons.tersescala.l.givenusing

case class PersonDto(fname:String, sname:String)
case class PersonDbRow(id:Option[Long], fname:String, sname:String)

@main def implicitConversion =

  given Conversion[PersonDto, PersonDbRow] with
    def apply(i:PersonDto):PersonDbRow =
      println("dto->dbRow")
      PersonDbRow(None, i.fname, i.sname)

  // Shorter version
  given Conversion[PersonDbRow, PersonDto]  =
    i=>
      println("dbRow->dto")
      PersonDto(i.fname, i.sname)

  // to enable implicit conversions in the file.
  import scala.language.implicitConversions

  // Insane this..
  // so the return type being dbRow means it invokes the conerter and returns the dbRow
  def takeInDtoGiveDb(dto:PersonDto):PersonDbRow = dto

  // Proof
  println("FIRST")
  val dbRow:PersonDbRow = takeInDtoGiveDb(PersonDto("Anomander","Rake"))
  // But Look, the converter changes the row param to the dto BEFORE calling the function
  // then it converts the dbRow returns to the dto again using the converter
  println("SECOND")
  val dto:PersonDto = takeInDtoGiveDb(dbRow)
