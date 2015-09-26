enablePlugins(ScalaJSPlugin)

name := "OpenSolid"

scalaVersion := "2.11.7"

postLinkJSEnv := NodeJSEnv().value

scalaJSStage in Global := FastOptStage

scalaJSOutputWrapper := (
  """
  'use strict';
  let __ScalaJSEnv = {
    exportsNamespace: exports
  };
  """,
  """
  const staticMembersSuffix = "_StaticMembers";
  const suffixLength = staticMembersSuffix.length;
  for (let exportedName in exports) {
    if (exportedName.endsWith(staticMembersSuffix)) {
      let staticMembers = exports[exportedName]();
      let className = exportedName.substring(0, exportedName.length - suffixLength);
      let destinationClass = exports[className];
      if (destinationClass !== undefined) {
        for (let memberName in staticMembers) {
          if (destinationClass[memberName] === undefined) {
            destinationClass[memberName] = staticMembers[memberName];
          }
        }
      }
    }
  }
  """
)
