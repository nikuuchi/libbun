package libbun.parser.ssa;

import libbun.ast.BNode;
import libbun.ast.ZLocalDefinedNode;
import libbun.util.Var;
import libbun.util.BArray;

public class JoinNode extends ZLocalDefinedNode {
	private final BArray<PHINode> PHIs;

	public JoinNode(BNode Parent) {
		super(null, null, 0);
		Parent.SetChild(this, true);
		this.PHIs = new BArray<PHINode>(new PHINode[0]);
	}

	public final void Append(PHINode Node) {
		this.PHIs.add(Node);
	}

	public final int size() {
		return this.PHIs.size();
	}

	public final PHINode ListAt(int Index) {
		return BArray.GetIndex(this.PHIs, Index);
	}

	public PHINode FindPHINode(Variable Var) {
		@Var int i = 0;
		while(i < this.size()) {
			PHINode Node = this.ListAt(i);
			if(Node.IsSameVariable(Var)) {
				return Node;
			}
			i = i + 1;
		}
		return null;
	}

	public boolean isJoinNodeOfRepeatNode() {
		// FIXME
		return false;
	}
}