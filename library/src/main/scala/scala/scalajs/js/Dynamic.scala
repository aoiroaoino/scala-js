/*                     __                                               *\
**     ________ ___   / /  ___      __ ____  Scala.js API               **
**    / __/ __// _ | / /  / _ | __ / // __/  (c) 2013, LAMP/EPFL        **
**  __\ \/ /__/ __ |/ /__/ __ |/_// /_\ \    http://scala-lang.org/     **
** /____/\___/_/ |_/____/_/ | |__/ /____/                               **
**                          |/____/                                     **
\*                                                                      */


/**
 * All doc-comments marked as "MDN" are by Mozilla Contributors,
 * distributed under the Creative Commons Attribution-ShareAlike license from
 * https://developer.mozilla.org/en-US/docs/Web/Reference/API
 */
package scala.scalajs.js

import scala.language.dynamics

import scala.scalajs.js
import scala.scalajs.js.annotation._

/** Dynamically typed JavaScript value.
 *
 *  Values of this trait accept all possible JavaScript operations in a
 *  dynamically typed way. You can read and write any field, call any method,
 *  apply any JavaScript operator to values of this type.
 */
@js.native
sealed trait Dynamic extends js.Any with scala.Dynamic {
  /** Calls a method of this object. */
  @JSBracketCall
  def applyDynamic(name: String)(args: js.Any*): js.Dynamic = js.native

  /** Reads a field of this object. */
  @JSBracketAccess
  def selectDynamic(name: String): js.Dynamic = js.native

  /** Writes a field of this object. */
  @JSBracketAccess
  def updateDynamic(name: String)(value: js.Any): Unit = js.native

  /** Calls this object as a callable. */
  def apply(args: js.Any*): js.Dynamic = js.native

  def unary_!(): js.Dynamic = js.native

  def unary_+(): js.Dynamic = js.native
  def unary_-(): js.Dynamic = js.native
  def unary_~(): js.Dynamic = js.native

  def +(that: js.Dynamic): js.Dynamic = js.native
  def -(that: js.Dynamic): js.Dynamic = js.native
  def *(that: js.Dynamic): js.Dynamic = js.native
  def /(that: js.Dynamic): js.Dynamic = js.native
  def %(that: js.Dynamic): js.Dynamic = js.native
  def <<(that: js.Dynamic): js.Dynamic = js.native
  def >>(that: js.Dynamic): js.Dynamic = js.native
  def >>>(that: js.Dynamic): js.Dynamic = js.native
  def &(that: js.Dynamic): js.Dynamic = js.native
  def |(that: js.Dynamic): js.Dynamic = js.native
  def ^(that: js.Dynamic): js.Dynamic = js.native

  def <(that: js.Dynamic): js.Dynamic = js.native
  def >(that: js.Dynamic): js.Dynamic = js.native
  def <=(that: js.Dynamic): js.Dynamic = js.native
  def >=(that: js.Dynamic): js.Dynamic = js.native

  def &&(that: js.Dynamic): js.Dynamic = js.native
  def ||(that: js.Dynamic): js.Dynamic = js.native

  // Work around the annoying implicits in Predef in Scala 2.10.
  def x: js.Dynamic = js.native
  def x_=(value: js.Any): Unit = js.native
}

/** Factory for dynamically typed JavaScript values. */
object Dynamic {
  /** Dynamic view of the global scope. */
  def global: js.Dynamic = throw new java.lang.Error("stub")

  /** Instantiates a new object of a JavaScript class. */
  def newInstance(clazz: js.Dynamic)(args: js.Any*): js.Object with js.Dynamic =
    throw new java.lang.Error("stub")

  /** Creates a new object with a literal syntax.
   *
   *  For example,
   *  {{{
   *  js.Dynamic.literal(foo = 3, bar = "foobar")
   *  }}}
   *  returns the JavaScript object
   *  {{{
   *  {foo: 3, bar: "foobar"}
   *  }}}
   */
  object literal extends scala.Dynamic { // scalastyle:ignore
    /** Literal creation with named arguments.
     *
     *  Example:
     *  {{{
     *  js.Dynamic.literal(name1 = "value", name2 = "value")
     *  }}}
     */
    def applyDynamicNamed(name: String)(
        fields: (String, js.Any)*): js.Object with js.Dynamic = {
      throw new java.lang.Error("stub")
    }

    /* Note that the `def applyDynamic` could simply be `def apply`, but this
     * would make the `applyDynamicNamed` case fail, since a call with named
     * arguments would be routed to the `def apply`, rather than the dynamic
     * version.
     */

    /** Literal creation with tuples of key/value.
     *
     *  Example:
     *  {{{
     *  js.Dynamic.literal("name1" -> "value", "name2" -> "value")
     *  }}}
     */
    def applyDynamic(name: String)(
        fields: (String, js.Any)*): js.Object with js.Dynamic = {
      throw new java.lang.Error("stub")
    }
  }
}
