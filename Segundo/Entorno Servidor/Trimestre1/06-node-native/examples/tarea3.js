function decomposeUrl(url) {
  const urlParts = url.match(
    /^(https?:\/\/)?(([\w.-]+)\.)?([\w.-]+\.[a-zA-Z]{2,4})(\/[^?#]*)?(\?[^#]*)?(#.*)?$/
  );

  if (!urlParts) {
    return null;
  }

  const [, protocol, , subDomain, domainName, folderTree, argumentsFile] =
    urlParts;

  const cleanedFolderTree = folderTree ? folderTree.slice(1) : null;

  return {
    protocol: protocol ? protocol.slice(0, -3) : null,
    subDomain: subDomain || null,
    domainName: domainName || null,
    folderTree: cleanedFolderTree ? cleanedFolderTree.split("/") : [],
    targetFile: cleanedFolderTree ? cleanedFolderTree.split("/").pop() : null,
    argumentsFile: argumentsFile || null,
  };
}

const url = "https://www.google.com/search/test.js?ok=1";
const result = decomposeUrl(url);
console.log(result);