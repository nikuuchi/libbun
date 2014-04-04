package libbun.lang.bun;

import libbun.ast.BNode;
import libbun.ast.binary.BBinaryNode;
import libbun.parser.BToken;
import libbun.parser.BTokenContext;
import libbun.util.BMatchFunction;
import libbun.util.Var;

public class BinaryPatternFunction extends BMatchFunction {

	@Override public BNode Invoke(BNode ParentNode, BTokenContext TokenContext, BNode LeftNode) {
		@Var BToken Token = TokenContext.GetToken(BTokenContext._MoveNext);
		@Var BBinaryNode BinaryNode = new BBinaryNode(ParentNode, Token, LeftNode, TokenContext.GetApplyingSyntax().SyntaxFlag);
		return BinaryNode.AppendParsedRightNode(ParentNode, TokenContext);
	}

}
