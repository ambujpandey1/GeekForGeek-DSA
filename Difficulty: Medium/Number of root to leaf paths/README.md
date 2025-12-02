<h2><a href="https://www.geeksforgeeks.org/problems/number-of-root-to-leaf-paths/1">Number of root to leaf paths</a></h2><h3>Difficulty Level : Difficulty: Medium</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size: 18px;">Given a binary tree, you need to find the number of all root-to-leaf paths along with their path lengths.<br><strong>Note:&nbsp;</strong></span><span style="font-size: 18px;">Every path length and number of root-to-leaf paths should be separated by&nbsp; "$".</span></p>
<p><span style="font-size: 18px;"><strong>Examples:</strong></span></p>
<pre><span style="font-size: 18px;"><strong>Input: </strong>root = [3, 2, 4]
      3
    /   \
   2     4</span>
<strong><span style="font-size: 18px;">Output:</span> </strong><span style="font-size: 18px;">2 2 $</span>
<span style="font-size: 18px;"><strong>Explanation : </strong>There are 2 roots to leaf paths of length 2(3 -&gt; 2 and 3 -&gt; 4)</span></pre>
<pre><strong><span style="font-size: 18px;">Input: </span></strong><span style="font-size: 18px;">root = [10, 20, 30, 40, 60]
        10
     /   \
    20    30
   / \    
  40  60</span>

<strong><span style="font-size: 18px;">Output:</span> </strong><span style="font-size: 18px;">2 1 $3 2 $</span>
<span style="font-size: 18px;"><strong>Explanation: </strong>There is 1 root leaf paths of length 2 and 2 roots to leaf paths of length 3.</span></pre>
<pre><span style="font-size: 18px;"><strong>Input: </strong>root = [3, 2, 5]
      3
    /   \
   2     5</span>
<strong><span style="font-size: 18px;">Output:</span> </strong><span style="font-size: 18px;">2 2 $</span>
<span style="font-size: 18px;"><strong>Explanation : </strong>There are 2 roots to leaf paths of length 2(3 -&gt; 2 and 3 -&gt; 4)</span></pre>
<p><span style="font-size: 18px;"><strong>Constraints:</strong><br>1 &lt;= number of nodes &lt;= 10<sup>5</sup><br>1 &lt;= node-&gt;data &lt;= 10<sup>5</sup></span></p></div><br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Tree</code>&nbsp;<code>Data Structures</code>&nbsp;