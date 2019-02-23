package huawei;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import huawei.exam.*;
import org.junit.Test;

/**
 * 实现类
 * 
 * 各方法请按要求返回，考试框架负责报文输出
 */
public class TetrisManiaImpl implements ExamOp
{

	/**
	 * ReturnCode(返回码枚举) .E001：非法命令 .E002：非法积木编号 .E003：非法移动距离 .E004：非法时间
	 * .E005：游戏结束 .E006：积木队列空间不足 .E007：游戏面板中不存在活动积木 .E008：操作时间不得小于系统时间
	 * .S001：操作成功
	 */

	/**
	 * Panel(游戏面板类) Panel(FillType[][] fillTypes)：构造函数，fillTypes - 填充类型矩阵
	 */

	/**
	 * FillType(填充类型枚举) .NONE：无积木填充 .FIXED：固定积木填充 .ACTIVE：活动积木填充
	 */

	/**
	 * Queue(积木队列类) Queue(int[] blocks)：构造函数，blocks - 积木编号数组
	 */

	/**
	 * 待考生实现，构造函数
	 */

	/**
	 * 简单功能的测试
	 *
	 */
	@Test

	public void listTest()
	{
		List<int[][]> a=new LinkedList<>();
		brickKind=new BrickKind(1);
		int x=brickKind.zero_1.length;
		System.out.println(x);
		a.add(brickKind.zero_1);
		a.add(brickKind.zero_2);
	}

	/**
	 * 数据结构
	 */

	BrickKind brickKind;		//积木      activityflag=1	???
	int[][] gameGround;			//固定场地
	int[][] activeGround;		//活动场地
	int[] activeBrick;			//活动积木及其旋转状态
	int tickTime;				//时间
	int[] brickList;			//积木队列
	int brickListLength;		//积木队列长度
	boolean hasActivieBrick;	//是否有活动积木
	boolean endGameFlag;		//游戏结束标志
	int[] moveAction;			//移动数组：左、右、下

	/**
	 * 状态更新函数
	 */
	public void statusUpdate(int time)
	{
		while (tickTime<time)
		{
			OpResult x;
			if (hasActivieBrick)
			{
				x=moveDown(1);
				tickTime++;
			}else
			{
				if (brickListLength>0)
				{
					activeBrick[0]=brickList[0];
					activeBrick[1]=0;
					for (int k=0;k<brickListLength-1;k++)
					{
						brickList[k]=brickList[k+1];
					}
					brickListLength=brickListLength-1;
					int index=activeBrick[0]*4+activeBrick[1];
					arrayCopy(brickKind.brickKindList.get(index),activeGround);
					int i,j;
					for (i=0;i<8;i++)
					{
						for (j=0;j<12;j++)
						{
							if (activeGround[i][j]==1&&gameGround[i][j]==1)
							{
								endGameFlag=true;
							}
						}
					}
					hasActivieBrick=true;
				}
			}
		}
	}


	/**
	 * 二维数组拷贝函数
	 */
	public void arrayCopy(int[][] old,int[][] now)
	{
		for (int i=0;i<old.length;i++)
		{
			now[i]=old[i].clone();
		}
	}


	//积木种类
	private class BrickKind
	{
		private int[][] ground;
		private int[][] zero_1,zero_2,zero_3,zero_4;
		private int[][] one_1,one_2,one_3,one_4;
		private int[][] two_1,two_2,two_3,two_4;
		private int[][] three_1,three_2,three_3,three_4;
		private int[][] four_1,four_2,four_3,four_4;
		private int[][] five_1,five_2,five_3,five_4;
		private int[][] six_1,six_2,six_3,six_4;
		private int[][] seven_1,seven_2,seven_3,seven_4;
		private int[][] eight_1,eight_2,eight_3,eight_4;
		private int[][] nine_1,nine_2,nine_3,nine_4;
		private int[][] ten_1,ten_2,ten_3,ten_4;
		private List<int[][]> brickKindList;


		public BrickKind(int activity_flag)
		{
			this.brickKindList=new LinkedList<>();


			this.ground=new int[8][12];
			int i,j;
			for (i=0;i<8;i++)
			{
				for (j=0;j<12;j++)
				{
					this.ground[i][j]=0;
				}

			}

			this.zero_1=new int[8][12];
			this.zero_2=new int[8][12];
			this.zero_3=new int[8][12];
			this.zero_4=new int[8][12];
			this.one_1=new int[8][12];
			this.one_2=new int[8][12];
			this.one_3=new int[8][12];
			this.one_4=new int[8][12];
			this.two_1=new int[8][12];
			this.two_2=new int[8][12];
			this.two_3=new int[8][12];
			this.two_4=new int[8][12];
			this.three_1=new int[8][12];
			this.three_2=new int[8][12];
			this.three_3=new int[8][12];
			this.three_4=new int[8][12];
			this.four_1=new int[8][12];
			this.four_2=new int[8][12];
			this.four_3=new int[8][12];
			this.four_4=new int[8][12];
			this.five_1=new int[8][12];
			this.five_2=new int[8][12];
			this.five_3=new int[8][12];
			this.five_4=new int[8][12];
			this.six_1=new int[8][12];
			this.six_2=new int[8][12];
			this.six_3=new int[8][12];
			this.six_4=new int[8][12];
			this.seven_1=new int[8][12];
			this.seven_2=new int[8][12];
			this.seven_3=new int[8][12];
			this.seven_4=new int[8][12];
			this.eight_1=new int[8][12];
			this.eight_2=new int[8][12];
			this.eight_3=new int[8][12];
			this.eight_4=new int[8][12];
			this.nine_1=new int[8][12];
			this.nine_2=new int[8][12];
			this.nine_3=new int[8][12];
			this.nine_4=new int[8][12];
			this.ten_1=new int[8][12];
			this.ten_2=new int[8][12];
			this.ten_3=new int[8][12];
			this.ten_4=new int[8][12];
			//0号积木

			arrayCopy(this.ground,this.zero_1);
			this.zero_1[3][0]=activity_flag;
			arrayCopy(this.zero_2,this.zero_1);
			arrayCopy(this.zero_3,this.zero_1);
			arrayCopy(this.zero_4,this.zero_1);

			//1号积木
			//1
			arrayCopy(this.ground,this.one_1);
			this.one_1[3][0]=activity_flag;
			this.one_1[3][1]=activity_flag;
			//2
			arrayCopy(this.ground,this.one_2);
			this.one_2[3][0]=activity_flag;
			this.one_2[4][0]=activity_flag;
			//3
			arrayCopy(this.ground,this.one_3);
			this.one_3[4][0]=activity_flag;
			this.one_3[4][1]=activity_flag;
			//4
			arrayCopy(this.ground,this.one_4);
			this.one_4[3][1]=activity_flag;
			this.one_4[4][1]=activity_flag;
			//2号积木
			//1
			arrayCopy(this.ground,this.two_1);
			this.two_1[3][0]=activity_flag;
			this.two_1[3][1]=activity_flag;
			this.two_1[3][2]=activity_flag;
			//2
			arrayCopy(this.ground,this.two_2);
			this.two_2[2][1]=activity_flag;
			this.two_2[3][1]=activity_flag;
			this.two_2[4][1]=activity_flag;
			//3
			arrayCopy(this.ground,this.two_3);
			this.two_3[3][0]=activity_flag;
			this.two_3[3][1]=activity_flag;
			this.two_3[3][2]=activity_flag;
			//4
			arrayCopy(this.ground,this.two_4);
			this.two_4[2][1]=activity_flag;
			this.two_4[3][1]=activity_flag;
			this.two_4[4][1]=activity_flag;
			//3号积木
			//1
			arrayCopy(this.ground,this.three_1);
			this.three_1[3][0]=activity_flag;
			this.three_1[4][0]=activity_flag;
			this.three_1[3][1]=activity_flag;
			//2
			arrayCopy(this.ground,this.three_2);
			this.three_2[3][0]=activity_flag;
			this.three_2[4][0]=activity_flag;
			this.three_2[4][1]=activity_flag;
			//3
			arrayCopy(this.ground,this.three_3);
			this.three_3[3][1]=activity_flag;
			this.three_3[4][0]=activity_flag;
			this.three_3[4][1]=activity_flag;
			//4
			arrayCopy(this.ground,this.three_4);
			this.three_4[3][0]=activity_flag;
			this.three_4[4][1]=activity_flag;
			this.three_4[3][1]=activity_flag;
			//4号积木
			//1
			arrayCopy(this.ground,this.four_1);
			this.four_1[3][0]=activity_flag;
			this.four_1[4][0]=activity_flag;
			this.four_1[4][1]=activity_flag;
			this.four_1[4][2]=activity_flag;
			//2
			arrayCopy(this.ground,this.four_2);
			this.four_2[5][0]=activity_flag;
			this.four_2[3][1]=activity_flag;
			this.four_2[4][1]=activity_flag;
			this.four_2[5][1]=activity_flag;
			//3
			arrayCopy(this.ground,this.four_3);
			this.four_3[4][0]=activity_flag;
			this.four_3[4][1]=activity_flag;
			this.four_3[4][2]=activity_flag;
			this.four_3[5][2]=activity_flag;
			//4
			arrayCopy(this.ground,this.four_4);
			this.four_4[3][1]=activity_flag;
			this.four_4[4][1]=activity_flag;
			this.four_4[5][1]=activity_flag;
			this.four_4[3][2]=activity_flag;
			//5号积木
			//1
			arrayCopy(this.ground,this.five_1);
			this.five_1[3][0]=activity_flag;
			this.five_1[4][0]=activity_flag;
			this.five_1[3][1]=activity_flag;
			this.five_1[3][2]=activity_flag;
			//2
			arrayCopy(this.ground,this.five_2);
			this.five_2[2][1]=activity_flag;
			this.five_2[3][1]=activity_flag;
			this.five_2[4][1]=activity_flag;
			this.five_2[4][2]=activity_flag;
			//3
			arrayCopy(this.ground,this.five_3);
			this.five_3[3][0]=activity_flag;
			this.five_3[3][1]=activity_flag;
			this.five_3[3][2]=activity_flag;
			this.five_3[2][2]=activity_flag;
			//4
			arrayCopy(this.ground,this.five_4);
			this.five_4[2][0]=activity_flag;
			this.five_4[2][1]=activity_flag;
			this.five_4[3][1]=activity_flag;
			this.five_4[4][1]=activity_flag;
			//6号积木
			//1
			arrayCopy(this.ground,this.six_1);
			this.six_1[4][0]=activity_flag;
			this.six_1[4][1]=activity_flag;
			this.six_1[3][1]=activity_flag;
			this.six_1[3][2]=activity_flag;
			//2
			arrayCopy(this.ground,this.six_2);
			this.six_2[3][0]=activity_flag;
			this.six_2[4][0]=activity_flag;
			this.six_2[4][1]=activity_flag;
			this.six_2[5][1]=activity_flag;
			//3
			arrayCopy(this.ground,this.six_3);
			this.six_3[5][0]=activity_flag;
			this.six_3[5][1]=activity_flag;
			this.six_3[4][1]=activity_flag;
			this.six_3[4][2]=activity_flag;
			//4
			arrayCopy(this.ground,this.six_4);
			this.six_4[3][1]=activity_flag;
			this.six_4[4][1]=activity_flag;
			this.six_4[4][2]=activity_flag;
			this.six_4[5][2]=activity_flag;
			//7号积木
			//1
			arrayCopy(this.ground,this.seven_1);
			this.seven_1[3][0]=activity_flag;
			this.seven_1[3][1]=activity_flag;
			this.seven_1[4][1]=activity_flag;
			this.seven_1[4][2]=activity_flag;
			//2
			arrayCopy(this.ground,this.seven_2);
			this.seven_2[3][1]=activity_flag;
			this.seven_2[4][1]=activity_flag;
			this.seven_2[2][2]=activity_flag;
			this.seven_2[3][2]=activity_flag;
			//3
			arrayCopy(this.ground,this.seven_3);
			this.seven_3[2][0]=activity_flag;
			this.seven_3[2][1]=activity_flag;
			this.seven_3[3][1]=activity_flag;
			this.seven_3[3][2]=activity_flag;
			//4
			arrayCopy(this.ground,this.seven_4);
			this.seven_4[3][0]=activity_flag;
			this.seven_4[4][0]=activity_flag;
			this.seven_4[2][1]=activity_flag;
			this.seven_4[3][1]=activity_flag;
			//8号积木
			//1
			arrayCopy(this.ground,this.eight_1);
			this.eight_1[3][0]=activity_flag;
			this.eight_1[3][1]=activity_flag;
			this.eight_1[3][2]=activity_flag;
			this.eight_1[3][3]=activity_flag;
			//2
			arrayCopy(this.ground,this.eight_2);
			this.eight_2[2][1]=activity_flag;
			this.eight_2[3][1]=activity_flag;
			this.eight_2[4][1]=activity_flag;
			this.eight_2[5][1]=activity_flag;
			//3
			arrayCopy(this.ground,this.eight_3);
			this.eight_3[4][0]=activity_flag;
			this.eight_3[4][1]=activity_flag;
			this.eight_3[4][2]=activity_flag;
			this.eight_3[4][3]=activity_flag;
			//4
			arrayCopy(this.ground,this.eight_4);
			this.eight_4[2][2]=activity_flag;
			this.eight_4[3][2]=activity_flag;
			this.eight_4[4][2]=activity_flag;
			this.eight_4[5][2]=activity_flag;
			//9号积木
			//1
			arrayCopy(this.ground,this.nine_1);
			this.nine_1[4][0]=activity_flag;
			this.nine_1[3][1]=activity_flag;
			this.nine_1[4][1]=activity_flag;
			this.nine_1[4][2]=activity_flag;
			//2
			arrayCopy(this.ground,this.nine_2);
			this.nine_2[4][0]=activity_flag;
			this.nine_2[3][1]=activity_flag;
			this.nine_2[4][1]=activity_flag;
			this.nine_2[5][1]=activity_flag;
			//3
			arrayCopy(this.ground,this.nine_3);
			this.nine_3[4][0]=activity_flag;
			this.nine_3[4][1]=activity_flag;
			this.nine_3[5][1]=activity_flag;
			this.nine_3[4][2]=activity_flag;
			//4
			arrayCopy(this.ground,this.nine_4);
			this.nine_4[3][1]=activity_flag;
			this.nine_4[4][1]=activity_flag;
			this.nine_4[5][1]=activity_flag;
			this.nine_4[4][2]=activity_flag;
			//10号积木
			arrayCopy(this.ground,this.ten_1);
			this.ten_1[3][0]=activity_flag;
			this.ten_1[4][0]=activity_flag;
			this.ten_1[3][1]=activity_flag;
			this.ten_1[4][1]=activity_flag;
			arrayCopy(this.ground,this.ten_2);
			arrayCopy(this.ground,this.ten_3);
			arrayCopy(this.ground,this.ten_4);

			brickKindList.add(this.zero_1);
			brickKindList.add(this.zero_2);
			brickKindList.add(this.zero_3);
			brickKindList.add(this.zero_4);
			brickKindList.add(this.one_1);
			brickKindList.add(this.one_2);
			brickKindList.add(this.one_3);
			brickKindList.add(this.one_4);
			brickKindList.add(this.two_1);
			brickKindList.add(this.two_2);
			brickKindList.add(this.two_3);
			brickKindList.add(this.two_4);
			brickKindList.add(this.three_1);
			brickKindList.add(this.three_2);
			brickKindList.add(this.three_3);
			brickKindList.add(this.three_4);
			brickKindList.add(this.four_1);
			brickKindList.add(this.four_2);
			brickKindList.add(this.four_3);
			brickKindList.add(this.four_4);
			brickKindList.add(this.five_1);
			brickKindList.add(this.five_2);
			brickKindList.add(this.five_3);
			brickKindList.add(this.five_4);
			brickKindList.add(this.six_1);
			brickKindList.add(this.six_2);
			brickKindList.add(this.six_3);
			brickKindList.add(this.six_4);
			brickKindList.add(this.seven_1);
			brickKindList.add(this.seven_2);
			brickKindList.add(this.seven_3);
			brickKindList.add(this.seven_4);
			brickKindList.add(this.eight_1);
			brickKindList.add(this.eight_2);
			brickKindList.add(this.eight_3);
			brickKindList.add(this.eight_4);
			brickKindList.add(this.nine_1);
			brickKindList.add(this.nine_2);
			brickKindList.add(this.nine_3);
			brickKindList.add(this.nine_4);
			brickKindList.add(this.ten_1);
			brickKindList.add(this.ten_2);
			brickKindList.add(this.ten_3);
			brickKindList.add(this.ten_4);
		}


	}



	public TetrisManiaImpl()
	{
	
	}

	/**
	 * 移动距离判别函数
	 * direction 0:left		1:right		2:down
	 */
	public int moveJudge(int direction,int distance)
	{
		int realDistance=distance;
		int i,j;
		switch (direction)
		{
			case 0:
				for(i=0;i<8;i++)
				{
					for (j=0;j<12;j++)
					{
						if (activeGround[i][j]==1)
						{
							if (i==0)
							{
								realDistance=0;
							}
							int k=0;
							for(k=i;k>=0;k--)
							{
								if (gameGround[k][j]==1&&realDistance>i-k)
								{
									realDistance =i-k;
								}
								else if (k==0&&realDistance>i-k)
								{
									realDistance=i-k;
								}
							}
						}
					}
				}
				break;
			case 1:
				for(i=0;i<8;i++)
				{
					for (j=0;j<12;j++)
					{
						if (activeGround[i][j]==1)
						{
							if (i==7)
							{
								realDistance=0;
							}
							int k;
							for(k=i;k<8;k++)
							{
								if (gameGround[k][j]==1&&realDistance>k-i)
								{
									realDistance =k-i;
								}
								else if (k==7&&realDistance>k-i)
								{
									realDistance =k-i;
								}
							}
						}
					}
				}
				break;
			case 2:
				for(i=0;i<8;i++)
				{
					for (j=0;j<12;j++)
					{
						if (activeGround[i][j]==1)
						{
							if (j==11)
							{
								realDistance=0;
							}
							int k;
							for(k=j;k<12;k++)
							{
								if (gameGround[i][k]==1&&realDistance>k-j)
								{
									realDistance =k-j;
								}
								else if (k==11&&realDistance>k-j)
								{
									realDistance =k-j;
								}
							}
						}
					}
				}
			break;
			default:
				break;
		}
		return realDistance;
	}

	/**
	 * 旋转判断
	 */

	public boolean conflictJudge(int[][] acBrick,int[] mAction)
	{
		int i,j;
		for (i=0;i<8;i++)
		{
			for (j=0;j<8;j++)
			{
				if (acBrick[i][j]==1)
				{
					int x,y;
					x=i-mAction[0]+mAction[1];
					y=j+mAction[2];
					if (acBrick[i][j]==1)
					{
						if (x>=0&&x<8&&y<12&&gameGround[x][y]==0)
						{}else{
							return true;
						}
					}

				}
			}
		}
		return false;
	}

	//更新活动砖块的场地为旋转后的情况
	public void rotateHandle(int[][] acBrick,int[] mAction)
	{
		arrayCopy(brickKind.ground,activeGround);
		int i,j;
		for (i=0;i<8;i++)
		{
			for (j=0;j<12;j++)
			{
				if (acBrick[i][j]==1)
				{
					activeGround[i-mAction[0]+mAction[1]][j+mAction[2]]=1;
				}
			}
		}
	}
	public boolean rotateJudge()
	{
		int index=activeBrick[0]*4+activeBrick[1];
		if(conflictJudge(brickKind.brickKindList.get(index),moveAction))
		{
			return false;
		}else{
			return true;
		}
	}

	/**
	 * 活动积木与固定积木判断与合并
	 * 如果可以合并，moveaction初始化
	 */
	public boolean combineGroundFlag()
	{
		boolean combineFlag=false;
		int i,j;
		for (i=0;i<8;i++)
		{
			for (j=0;j<12;j++)
			{
				if (activeGround[i][j]==1&&gameGround[i][j+1]==1)
				{
					combineFlag=true;
				}
			}
		}
		return combineFlag;
	}

	public void deleteFullLine()
	{
		int i,j;
		int sum;
		for (j=11;j>=0;j--)
		{
			sum=0;
			for (i=0;i<8;i++)
			{
				sum=sum+gameGround[i][j];
			}

			if (sum==8)
			{
				int m,n;
				for (m=j;m>=0;m--)
				{
					for (n=0;n<8;n++)
						if (m==0)
						{
							gameGround[n][m]=0;
						}else
						{
							gameGround[n][m]=gameGround[n][m-1];
						}
				}
				j=j+1;
			}
		}
	}

	public void combineGround()
	{
		int i,j;
		moveAction[0]=moveAction[1]=moveAction[2]=0;
		for (i=0;i<8;i++)
		{
			for (j=0;j<12;j++)
			{
				gameGround[i][j]=gameGround[i][j]+activeGround[i][j];
			}
		}
		deleteFullLine();
		if (brickListLength>0)		//更新活动积木
		{
			for (int k=0;k<brickListLength-1;k++)
			{
				brickList[k]=brickList[k+1];
			}
			activeBrick[0]=brickList[0];
			activeBrick[1]=0;
			brickListLength=brickListLength-1;
			int index=activeBrick[0]*4+activeBrick[1];
			arrayCopy(brickKind.brickKindList.get(index),activeGround);
			for (i=0;i<8;i++)
			{
				for (j=0;j<12;j++)
				{
					if (activeGround[i][j]==1&&gameGround[i][j]==1)
					{
						endGameFlag=true;
					}
				}
			}
			hasActivieBrick=true;
		}else{
			hasActivieBrick=false;
			activeBrick[0]=66;
			activeBrick[1]=0;
		}
	}

	/**
	 * 将系统重置为初始状态
	 * 固定场地、活动积木场地、时间
	 * 活动积木种类及旋转状态
	 * 积木队列、积木队列长度
	 * 游戏结束标志
	 * @return 返回码
	 */
	@Override
	public OpResult reset()
	{
		brickKind=new BrickKind(1);
		gameGround=new int[8][12];
		activeGround=new int[8][12];
		arrayCopy(brickKind.ground,gameGround);
		arrayCopy(brickKind.ground,activeGround);
		activeBrick=new int[2];
		activeBrick[0]=66;	//无积木时认为是66
		activeBrick[1]=0;
		hasActivieBrick=false;
		moveAction=new int[3];
		moveAction[0]=moveAction[1]=moveAction[2]=0;
		tickTime=0;
		brickList=new int[10];
		brickListLength=0;
		endGameFlag=false;

		return new OpResult(ReturnCode.S001);
	}

	/**
	 * (1) 创建指定编号的一个或多个积木，新创建的积木按命令参数从左至右的顺序加入积木队列。此时若游戏面板中不存在活动积木，
	 * 系统从积木队列中取出居于首位的积木，在游戏面板中指定位置生成； (2) 积木编号取[0, 10]范围内的整数，值的合法性不作为考点，考生无须关注；
	 * (3) 命令携带参数个数取[1, 10]内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param ids
	 *            积木编号序列
	 * @return 返回码
	 */
	@Override
	public OpResult create(int[] ids)
	{
		if (endGameFlag)
		{
			return new OpResult(ReturnCode.E005);
		}else {
			if (ids.length+brickListLength>10)
			{
				return new OpResult(ReturnCode.E006);
			}else{
				int len=brickListLength+ids.length;
				for (int i=0;i<ids.length;i++)
				{
					brickList[brickListLength+i]=ids[i];
				}
				brickListLength=len;
				return new OpResult(ReturnCode.S001);
			}
		}


	}

	/**
	 * (1) 将活动积木向左移动指定的距离，移动距离以宫格数量计量； (2)
	 * 在移动过程中，当活动积木中任一方块的左边界与游戏面板左边界或固定积木方块右边界接触时，活动积木无法继续左移，
	 * 系统对本次操作命令的处理终结，左移操作成功； (3)
	 * 因面板边界或其它积木阻挡导致实际可移动距离小于输入的移动距离时，活动积木只按实际距离移动并返回操作成功； (4)
	 * 左移距离取[1，8]范围内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param distance
	 *            移动距离
	 * @return 返回码
	 */
	@Override
	public OpResult moveLeft(int distance)
	{
		if (endGameFlag)
		{
			return new OpResult(ReturnCode.E005);
		}else {
			if (!hasActivieBrick)
			{
				return new OpResult(ReturnCode.E007);
			}
			else{
				int realDistance=moveJudge(0,distance);
				moveAction[0]=moveAction[0]+realDistance;//记录总的左移距离
				for (int i=0;i<8;i++)
				{
					for (int j=0;j<12;j++)
					{
						if (i>7-realDistance)
						{
							activeGround[i][j]=0;
						}else
						{
							activeGround[i][j]=activeGround[i+realDistance][j];
						}

					}
				}
				return new OpResult(ReturnCode.S001);
			}
		}
	}

	/**
	 * (1) 将活动积木向右移动指定的距离，移动距离以宫格数量计量； (2)
	 * 在移动过程中，当活动积木中任一方块的右边界与游戏面板右边界或固定积木方块左边界接触时，
	 * 活动积木无法继续右移，系统对本次操作命令的处理终结，右移操作成功； (3)
	 * 因面板边界或其它积木阻挡导致实际可移动距离小于输入的移动距离时，活动积木只按实际距离移动并返回操作成功； (4)
	 * 右移距离取[1，8]范围内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param distance
	 *            移动距离
	 * @return 返回码
	 */
	@Override
	public OpResult moveRight(int distance)
	{
		if (endGameFlag)
		{
			return new OpResult(ReturnCode.E005);
		}else {
			if (!hasActivieBrick)
			{
				return new OpResult(ReturnCode.E007);
			}
			else{
				int realDistance=moveJudge(1,distance);
				moveAction[1]=moveAction[1]+realDistance;//记录总的右移距离
				for (int i=7;i>=0;i--)
				{
					for (int j=0;j<12;j++)
					{
						if (i<realDistance)
						{
							activeGround[i][j]=0;
						}else
						{
							activeGround[i][j]=activeGround[i-realDistance][j];
						}

					}
				}
				return new OpResult(ReturnCode.S001);
			}
		}
	}

	/**
	 * (1) 将活动积木向下移动指定的距离，移动距离以宫格数量计量； (2)
	 * 在移动过程中，当活动积木中任一方块的下边界与游戏面板下边界或固定积木方块上边界接触时，
	 * 活动积木无法继续下移，系统对本次操作命令的处理终结，下移操作成功； (3)
	 * 因面板边界或其它积木阻挡导致实际可移动距离小于输入的移动距离时，活动积木只按实际距离移动并变为固定积木，触发满行消除，操作返回成功； (4)
	 * 下移距离取[1，12]范围内的整数，值的合法性不作为考点，考生无须关注。
	 * 
	 * 
	 * @param distance
	 *            移动距离
	 * @return 返回码
	 */
	@Override
	public OpResult moveDown(int distance)
	{
		if (endGameFlag)
		{
			return new OpResult(ReturnCode.E005);
		}else {
			if (!hasActivieBrick)
			{
				return new OpResult(ReturnCode.E007);
			}
			else{
				int realDistance=moveJudge(2,distance);
				moveAction[2]=moveAction[2]+realDistance;//记录总的下移距离
				for (int j=11;j>=0;j--)
				{
					for (int i=0;i<8;i++)
					{
						if (j<realDistance)
						{
							activeGround[i][j]=0;
						}else
						{
							activeGround[i][j]=activeGround[i][j-realDistance];
						}

					}
				}
				if (realDistance<distance)
				{
					combineGround();
				}
				return new OpResult(ReturnCode.S001);
			}
		}
	}

	/**
	 * (1) 将活动积木顺时针旋转一次； (2) 活动积木无法旋转时，保持当前位置与形态不变。
	 * 
	 * @return 返回码
	 */
	@Override
	public OpResult rotate()
	{
		int kindIndex=activeBrick[1];
		activeBrick[1]=(activeBrick[1]+1)%4;
		if (endGameFlag)
		{
			return new OpResult(ReturnCode.E005);
		}else {
			if(hasActivieBrick)
			{
				if (rotateJudge()) //如果可以旋转
				{
					int index=activeBrick[0]*4+activeBrick[1];
					rotateHandle(brickKind.brickKindList.get(index),moveAction);
				}else{
					activeBrick[1]=kindIndex;
				}
				return new OpResult(ReturnCode.S001);

			}else
			{
				return new OpResult(ReturnCode.E007);
			}
		}


	}

	/**
	 * (1) 时间不小于当前系统时间时，优先触发系统时间更新至命令携带的时间，在指定时间点对游戏面板进行查询，； (2)
	 * 时间取[0,1000]范围内整数，值的合法性不作为考点，考生无须关注； (3)
	 * 本命令不受游戏进度影响，即使游戏结束，命令依然生效，将系统时间更新至输入的时间并输出查询结果。
	 * 
	 * @param time
	 *            时间
	 * @return 查询结果
	 */
	@Override
	public OpResult queryPanel(int time)
	{
		if (time<tickTime)
		{
			return new OpResult(ReturnCode.E008);
		}else{
			statusUpdate(time);
			FillType[][] fillTypes=new FillType[8][12];
			int i,j;
			for (i=0;i<8;i++)
			{
				for (j=0;j<12;j++)
				{
					if (gameGround[i][j]==1)
					{
						fillTypes[i][j]=FillType.FIXED;
					}
					if (activeGround[i][j]==1)
					{
						fillTypes[i][j]=FillType.ACTIVE;
					}
					if (gameGround[i][j]==0&&activeGround[i][j]==0)
					{
						fillTypes[i][j]=FillType.NONE;
					}

				}
			}
			return new OpResult(new Panel(fillTypes));

		}
	}

	/**
	 * 查询积木队列
	 * 
	 * @param time
	 *            时间
	 * @return 查询结果
	 */
	@Override
	public OpResult queryQueue(int time)
	{
		if (time<tickTime)
		{
			return new OpResult(ReturnCode.E008);
		}else {
			statusUpdate(time);
			int[] block=new int[brickListLength];
			int i;
			for (i=0;i<brickListLength;i++)
			{
				block[i]=brickList[i];
			}
			return new OpResult(new Queue(block));
		}
	}


}
